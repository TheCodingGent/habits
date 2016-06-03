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
    // Create the adapter to convert the array to views
    HabitListAdapter adapter;
    User user;
    Habit habit;
    //created habit object for testing
    //TODO: remove before pushing files
    Habit defaultHabit =
            new Habit("Default Habit","This is how the Habit description is shown",5,1234);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        user = new User("Me","me@ayapp.com","password");
        //add random habit to arrayOfHabits for testing
        // TODO: remove before pushing files
        user.addHabit(defaultHabit);

        adapter = new HabitListAdapter(this, user.getHabits());
        ListView habitListView = (ListView) findViewById(R.id.habitListView);
        habitListView.setAdapter(adapter);

        //Add Habit Button
        FloatingActionButton addNewHabitButton =
                (FloatingActionButton) findViewById(R.id.addNewHabitButton);
        assert addNewHabitButton != null;
        addNewHabitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                int goal = data.getIntExtra("goal",1);

                habit = new Habit(name, description, goal, 1234); //add ID when available
                user.addHabit(habit);
                adapter.notifyDataSetChanged();
            }
        }
    }
}
