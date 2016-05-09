package com.example.ayapp.habits;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Construct the data source
    // TODO: switch this arraylist with user.arraylist
    ArrayList<Habit> arrayOfHabits;
    // Create the adapter to convert the array to views
    HabitListAdapter adapter;

    //created habit object for testing
    //TODO: remove before pushing files
    Habit defaultHabit = new Habit("Default Habit","This is how the Habit description is shown",5,1234);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        //initialize the ArrayList
        arrayOfHabits = new ArrayList<Habit>();
        //add random habit to arrayOfHabits for testing
        // TODO: remove before pushing files
        arrayOfHabits.add(defaultHabit);

        //initialize the adapter
        adapter = new HabitListAdapter(this, arrayOfHabits);
        // Attach the adapter to a ListView
        ListView habitListView = (ListView) findViewById(R.id.habitListView);
        habitListView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //used to check to see if the list is refreshing
                //TODO: fix before pushing files
                arrayOfHabits.add(defaultHabit);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
