package com.example.ayapp.habits;

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
    };

    public User(int id, String username, String email, String password){
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.habits = new ArrayList<Habit>();
    }

    public User(int id, String username, String email, String password, ArrayList<Habit> habits){
        this.id = id;
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
     * UTILITY METHODS
     **********************************************************************************************/
    @Override
    public String toString() {
        return "User [Username=" + username + ", Email=" + email + ", Password=" + password
                + "]";
    }

}
