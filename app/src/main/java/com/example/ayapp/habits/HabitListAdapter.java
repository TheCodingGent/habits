package com.example.ayapp.habits;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by amoughnie on 07-May-16.
 */
public class HabitListAdapter extends ArrayAdapter<Habit> {

    public HabitListAdapter(Context context, ArrayList<Habit> habits) {
        super(context, 0, habits);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position
        Habit habit = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.habit_row, parent, false);
        }
        // Lookup view for data population
        TextView habitTitle = (TextView) convertView.findViewById(R.id.habitTitle);
        TextView habitDescription = (TextView) convertView.findViewById(R.id.habitDescription);
        TextView habitGoal = (TextView) convertView.findViewById(R.id.habitGoal);

        // Populate the data into the template view using the data object
        habitTitle.setText(habit.getTitle());
        habitDescription.setText(habit.getDescription());
        //TODO: fix what the string says and extract string resource
        habitGoal.setText("Plan to finish the habit in "+habit.getGoal()+" days.");

        // Return the completed view to render on screen
        return convertView;
    }
}
