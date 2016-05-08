package com.example.ayapp.habits;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //created habit object for testing
    Habit habit = new Habit("first habit","this is a habit created for testing",5,1234);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        // Construct the data source
        ArrayList<Habit> arrayOfHabits = new ArrayList<Habit>();
        //add random habit to arrayOfHabits for testing
        arrayOfHabits.add(habit);
        arrayOfHabits.add(habit);
        
        // Create the adapter to convert the array to views
        HabitListAdapter adapter = new HabitListAdapter(this, arrayOfHabits);
        // Attach the adapter to a ListView
        ListView habitListView = (ListView) findViewById(R.id.habitListView);
        habitListView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
