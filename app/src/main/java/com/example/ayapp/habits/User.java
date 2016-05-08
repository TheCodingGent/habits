package com.example.ayapp.habits;

import java.util.ArrayList;

/**
 * Created by yasser.ghamlouch on 2016-05-07.
 */

public class User {
    /***********************************************************************************************
     * VARIABLES
     **********************************************************************************************/
    // Private instance variables
    private int id;
    private int habitsId;
    private String username;
    private String email;
    private String password;
    private ArrayList<Habit> habits;


    /***********************************************************************************************
     * CONSTRUCTORS
     **********************************************************************************************/
    public User(){
        this.id = -1;
        this.username = null;
        this.email = null;
        this.password = null;
        this.habits = null;
        this.habitsId = -1;
    }

    public User(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
        this.habits = new ArrayList<Habit>();
    }

    public User(String username, String email, String password, ArrayList<Habit> habits){
        this.username = username;
        this.email = email;
        this.password = password;
        this.habits = habits;
    }


    /***********************************************************************************************
     * SETTERS AND GETTERS
     **********************************************************************************************/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHabitsId() {
        return habitsId;
    }

    public void setHabitsId(int habitsId) {
        this.habitsId = habitsId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Habit> getHabits() {
        return habits;
    }

    public void setHabits(ArrayList<Habit> habits) {
        this.habits = habits;
    }

    /***********************************************************************************************
     * API - PUBLIC INTERFACE
     **********************************************************************************************/
    public boolean addHabit(Habit habit){
        boolean result = false;
        if (habit != null){
            habits.add(habit);
            result = true;
        }
        return result;
    }

    public boolean removeHabit(Habit habit){
        boolean result = false;
        if (habit != null){
            habits.remove(habit);
            result = true;
        }
        return result;
    }

    /***********************************************************************************************
     * UTILITY METHODS
     **********************************************************************************************/
    @Override
    public String toString() {
        return "User [Username=" + username + ", Email=" + email + ", Password=" + password
                + "]";
    }

}
