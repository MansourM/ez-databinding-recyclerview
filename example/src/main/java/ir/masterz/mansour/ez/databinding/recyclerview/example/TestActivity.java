package ir.masterz.mansour.ez.databinding.recyclerview.example;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
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

        Person person1 = new Person("John Doe", 18);
        Person person2 = new Person("Jane Doe", 20);

        ArrayList<Person> personnel = new ArrayList<>();
        personnel.add(person1);
        personnel.add(person2);

        adapter = new TestAdapter(personnel);
        binding.rvDataBindingExample.setLayoutManager(new LinearLayoutManager(this));
        binding.rvDataBindingExample.setAdapter(adapter);
    }
}