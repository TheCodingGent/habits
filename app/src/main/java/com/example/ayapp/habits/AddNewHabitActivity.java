package com.example.ayapp.habits;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNewHabitActivity extends AppCompatActivity {

    /********************************************************************************************
     * VARIABLES
     *******************************************************************************************/
    Intent intent;
    EditText habitName;
    EditText habitDescription;
    EditText habitGoal;
    Button addHabitButton;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_habit);

        intent = new Intent();

        habitName = (EditText) findViewById(R.id.addHabitNameEditText);
        habitDescription = (EditText) findViewById(R.id.addDescriptionEditText);
        habitGoal = (EditText) findViewById(R.id.addGoalEditText);
        addHabitButton = (Button) findViewById(R.id.addHabitButton);

        addHabitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("name", habitName.getText().toString());
                intent.putExtra("description", habitDescription.getText().toString());
                intent.putExtra("goal", habitGoal.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
