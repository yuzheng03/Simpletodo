package com.example.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText todo;
    Button add;
    Button clear;
    ListView lvtodo;
    ArrayList<String> altodo;
    ArrayAdapter<String> aatodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todo=findViewById(R.id.todo);
        add=findViewById(R.id.button);
        clear=findViewById(R.id.button2);
        lvtodo=findViewById(R.id.lv);
        altodo=new ArrayList<>();

        aatodo=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,altodo);
        lvtodo.setAdapter(aatodo);

        add.setOnClickListener((view) -> {
            String newtodo = todo.getText().toString();
            altodo.add(newtodo);
            aatodo.notifyDataSetChanged();
        });
        clear.setOnClickListener((view) -> {
            altodo.clear();
            aatodo.notifyDataSetChanged();
        });
    }
}