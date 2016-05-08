package com.example.ayapp.habits;

import java.util.ArrayList;

/**
 * Created by yasser.ghamlouch on 2016-05-07.
 */
public class User {


    // Private instance variables
    private String mUsername;
    private String mEmail;
    private String mPassword;
    private ArrayList<Habit> mHabits;


    public User(String username, String email, String password){
        this.mUsername = username;
        this.mEmail = email;
        this.mPassword = password;
        this.mHabits = new ArrayList<Habit>();
    }

    public User(String username, String email, String password, ArrayList<Habit> habits){
        this.mUsername = username;
        this.mEmail = email;
        this.mPassword = password;
        this.mHabits = habits;
    }

    // Setters and getters
    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        this.mUsername = username;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        this.mEmail = email;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        this.mPassword = password;
    }

    public ArrayList<Habit> getHabits() {
        return mHabits;
    }

    public void setHabits(ArrayList<Habit> habits) {
        this.mHabits = habits;
    }

    @Override
    public String toString() {
        return "User [Username=" + mUsername + ", Email=" + mEmail + ", Password=" + mPassword
                + "]";
    }

}
