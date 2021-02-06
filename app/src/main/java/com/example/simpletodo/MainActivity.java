package com.example.simpletodo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.*;

public class MainActivity extends AppCompatActivity {
    // Declare Variables

    // Model
    List<String> items;
    // View Components
    Button btnAdd;
    EditText etItem;
    RecyclerView rvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Variables

        // Model
        items = new ArrayList<>();
        items.add("Buy milk");
        items.add("Go to the gym");
        items.add("Have fun!");
        // View
        btnAdd = findViewById(R.id.btnAdd);
        etItem = findViewById(R.id.etItem);
        rvItems = findViewById(R.id.rvItems);

        //Adapter
        ItemsAdapter itemsAdapter = new ItemsAdapter(items);
        rvItems.setAdapter(itemsAdapter);
        rvItems.setLayoutManager(new LinearLayoutManager(this));


        //Onclick listener - Add
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            // Someone clicked
            public void onClick(View v) {
                // get text from edit box & make it a string
                String todoItem = etItem.getText().toString();

                // add item to the model
                items.add(todoItem);

                //Notify adapter that an item is inserted and the position/index of the item
                itemsAdapter.notifyItemInserted(items.size() - 1);

                // clear edit text box
                etItem.setText("");

                Toast.makeText(getApplicationContext(), "Item was added", Toast.LENGTH_SHORT).show();


            }
        });

    }
}