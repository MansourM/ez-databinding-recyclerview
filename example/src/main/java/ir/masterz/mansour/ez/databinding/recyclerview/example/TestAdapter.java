package ir.masterz.mansour.ez.databinding.recyclerview.example;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import ir.masterz.mansour.ez.databinding.recyclerview.adapter.DataBindingRecyclerViewAdapter;
import ir.masterz.mansour.ez.databinding.recyclerview.adapter.DataBindingViewHolder;
import ir.masterz.mansour.ez.databinding.recyclerview.example.databinding.ItemPersonBindingImpl;

public class TestAdapter extends DataBindingRecyclerViewAdapter<Person> {


    public TestAdapter(ArrayList<Person> personnel) {
        super(personnel);
    }

    @Override
    public void onBindViewHolder(@NonNull DataBindingViewHolder<Person> holder, int position) {
        super.onBindViewHolder(holder, position);
    }

    @Override
    protected int getLayoutIdForPosition(int position) {
        return R.layout.item_person;
    }
}
