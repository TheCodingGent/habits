package com.example.ayapp.habits;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /***********************************************************************************************
     * VARIABLES
     **********************************************************************************************/
    // Construct the data source
    // TODO: switch this arraylist with user.arraylist
    ArrayList<Habit> arrayOfHabits;
    // Create the adapter to convert the array to views
    HabitListAdapter adapter;
    //created habit object for testing
    //TODO: remove before pushing files
    Habit defaultHabit = new Habit("Default Habit","This is how the Habit description is shown",5,1234);
    Habit habit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        //List of Habits
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

        //Add Habit Button
        FloatingActionButton addNewHabitButton = (FloatingActionButton) findViewById(R.id.addNewHabitButton);
        assert addNewHabitButton != null;
        addNewHabitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //starting the add new habit activity
                //note the onActivityResult method adds the habit to the list directly
                Intent intent = new Intent(MainActivity.this, AddNewHabitActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if(resultCode == RESULT_OK){
                String name = data.getStringExtra("name");
                String description = data.getStringExtra("description");
                int goal;
                try {
                    goal = Integer.parseInt(data.getStringExtra("goal"));
                } catch (NumberFormatException nfe) {
                    goal = 0;
                }

                habit = new Habit(name,description,goal, 1234);
                arrayOfHabits.add(habit);
                adapter.notifyDataSetChanged();
            }
        }
    }
}
