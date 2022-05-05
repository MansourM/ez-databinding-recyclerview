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
    public void onBindViewHolder(DataBindingViewHolder<Person, ItemPersonBinding> holder, int position) {
        super.onBindViewHolder(holder, position);
        holder.getBinding().tvAge.setOnClickListener(view -> {
            Toast.makeText(view.getContext(), "age", Toast.LENGTH_LONG).show();
        });
    }

    @Override
    protected int getLayoutIdForPosition(int position) {
        return R.layout.item_person;
    }
}
