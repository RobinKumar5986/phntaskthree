package com.example.phntaskthree;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    String[] s= {"Aarav", "Aditi", "Anika", "Arya", "Chirag", "Devanshi", "Dhruv", "Esha", "Gaurav",
            "Harsh", "Ishaan", "Jhanvi", "Kabir", "Kavya", "Lakshya", "Mira", "Neha", "Om", "Pranav",
            "Prisha", "Rahul", "Rhea", "Rohan", "Sahana", "Samarth", "Sanvi", "Shanaya", "Shreya",
            "Siddharth", "Srishti", "Suhana", "Tanvi", "Tanya", "Tara", "Tisha", "Uma", "Urvi",
            "Ved", "Vidhi", "Vikram", "Yash", "Yuvraj", "Zara", "Zoya", "Advait", "Akshay", "Daksh",
            "Ishani", "Navya"};

    ListView listView;
    SearchView searchView;
    Switch aSwitch;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.myList);
        searchView=findViewById(R.id.search);
        searchView.setVisibility(View.INVISIBLE);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,s);

        listView.setAdapter(adapter);
        aSwitch=findViewById(R.id.switch1);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked){
                    searchView.setVisibility(View.INVISIBLE);
                }else{
                    searchView.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}