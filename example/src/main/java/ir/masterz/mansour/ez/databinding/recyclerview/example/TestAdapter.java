package ir.masterz.mansour.ez.databinding.recyclerview.example;

import android.widget.Toast;

import java.util.ArrayList;

import ir.masterz.mansour.ez.databinding.recyclerview.adapter.DataBindingRecyclerViewAdapter;
import ir.masterz.mansour.ez.databinding.recyclerview.adapter.DataBindingViewHolder;
import ir.masterz.mansour.ez.databinding.recyclerview.example.databinding.ItemPersonBinding;

public class TestAdapter extends DataBindingRecyclerViewAdapter<Person, ItemPersonBinding> {


    public TestAdapter(ArrayList<Person> personnel) {
        super(personnel);
    }

    @Override
    public void onBindViewHolder(DataBindingViewHolder<ItemPersonBinding> holder, int position) {
        super.onBindViewHolder(holder, position);
        //Do stuff here
        holder.getBinding().tvAge.setOnClickListener(view -> {
            Toast.makeText(view.getContext(), "age", Toast.LENGTH_LONG).show();
        });
        //Example for binding multiple objects
        holder.bind(BR.index, position + 1, false);
        holder.bind(BR.person, getObjForPosition(position));
    }

    @Override
    protected int getLayoutIdForPosition(int position) {
        return R.layout.item_person;
    }
}
