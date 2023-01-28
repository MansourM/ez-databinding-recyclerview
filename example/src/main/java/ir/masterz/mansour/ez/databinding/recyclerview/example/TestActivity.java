package ir.masterz.mansour.ez.databinding.recyclerview.example;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

import ir.masterz.mansour.ez.databinding.recyclerview.example.databinding.ActivityTestBinding;

public class TestActivity extends AppCompatActivity {

    private ActivityTestBinding binding;
    private TestAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Person person1 = new Person("John Doe", 20);
        Person person2 = new Person("Jane Doe", 18);
        Person person3 = new Person("The Poo", 8);
        Person person4 = new Person("What Who", 0);

        ArrayList<Person> personnel = new ArrayList<>();
        personnel.add(person1);
        personnel.add(person2);
        personnel.add(person3);
        personnel.add(person4);

        adapter = new TestAdapter(personnel);
        binding.rvDataBindingExample.setLayoutManager(new LinearLayoutManager(this));
        binding.rvDataBindingExample.setAdapter(adapter);

    }
}