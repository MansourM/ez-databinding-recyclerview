package ir.masterz.mansour.ez.databinding.recyclerview.example;

import java.util.ArrayList;

import ir.masterz.mansour.ez.databinding.recyclerview.adapter.DataBindingRecyclerViewAdapter;

public class TestAdapter extends DataBindingRecyclerViewAdapter<Person> {


    public TestAdapter(ArrayList<Person> personnel) {
        super(personnel);
    }

    @Override
    protected int getLayoutIdForPosition(int position) {
        return R.layout.item_person;
    }
}
