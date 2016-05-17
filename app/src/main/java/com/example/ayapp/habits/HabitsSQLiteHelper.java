package com.example.ayapp.habits;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

/**
 * Created by yasser.ghamlouch on 2016-05-07.
 *
 * A helper class for manipulating data in the database using SQLite.
 */
public class HabitsSQLiteHelper extends SQLiteOpenHelper{
    /***********************************************************************************************
     * CONSTANTS
     **********************************************************************************************/
    // database version
    private static final int database_VERSION = 1;
    // database name
    private static final String database_NAME = "HabitsDB";
    private static final String table_USERS = "users";
    private static final String user_ID = "user_id";
    private static final String user_USERNAME = "user_username";
    private static final String user_EMAIL = "user_email";
    private static final String user_PASSWORD = "user_password";
    private static final String user_HABITSID = "user_habits_id";

    private static final String table_HABITS = "habits";
    private static final String habit_ID = "habit_id";
    private static final String habit_TITLE = "habit_title";
    private static final String habit_DESCRIPTION = "habit_description";
    private static final String habit_GOAL = "habit_goal";
    private static final String habit_USER_ID = "habit_user_id";

    private static final String[] USER_COLUMNS = {user_ID, user_USERNAME, user_EMAIL, user_PASSWORD };
    private static final String[] HABIT_COLUMNS = {habit_ID, habit_TITLE, habit_DESCRIPTION, habit_GOAL };


    /***********************************************************************************************
     * CONSTRUCTOR
     **********************************************************************************************/
    public HabitsSQLiteHelper(Context context) {
        super(context, database_NAME, null, database_VERSION);
    }


    /***********************************************************************************************
     * API - PUBLIC INTERFACE
     **********************************************************************************************/
    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create users table
        String CREATE_USERS_TABLE = "CREATE TABLE users ( " + "user_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "username TEXT, " + "email TEXT, " + "password TEXT, " + "habits_id INTEGER )";
        db.execSQL(CREATE_USERS_TABLE);

        // SQL statement to create habits table
        String CREATE_HABITS_TABLE = "CREATE TABLE habits ( " + "habit_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "title TEXT, " + "description TEXT, " + "goal INTEGER, " + "habit_user_id INTEGER )";
        db.execSQL(CREATE_HABITS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // drop users table if already exists
        db.execSQL("DROP TABLE IF EXISTS users");
        // drop habits table if already exists
        db.execSQL("DROP TABLE IF EXISTS habits");
        this.onCreate(db);
    }

    public void createUser(User user) {
        // get reference of the HabitsDB database
        SQLiteDatabase db = this.getWritableDatabase();

        // make values to be inserted
        ContentValues values = new ContentValues();
        values.put(user_USERNAME, user.getUsername());
        values.put(user_EMAIL, user.getEmail());
        values.put(user_PASSWORD, user.getPassword());

        // insert user
        db.insert(table_USERS, null, values);

        // close database transaction
        db.close();
    }

    public void createHabit(Habit habit) {
        // get reference of the HabitsDB database
        SQLiteDatabase db = this.getWritableDatabase();

        // make values to be inserted
        ContentValues values = new ContentValues();
        values.put(habit_TITLE, habit.getTitle());
        values.put(habit_DESCRIPTION, habit.getDescription());
        values.put(habit_GOAL, habit.getGoal());

        // insert user
        db.insert(table_HABITS, null, values);

        // close database transaction
        db.close();
    }

    public User readUser(String email) {
        // get reference of the BookDB database
        SQLiteDatabase db = this.getReadableDatabase();
        User user = new User();

        // get user query
        Cursor cursor = db.query(table_USERS, // a. table
                USER_COLUMNS, " username = ?", null, null, email, null, null);

        // if results !=null, parse the first one
        if (cursor != null) {
            cursor.moveToFirst();
            user.setId(Integer.parseInt(cursor.getString(0)));
            user.setUsername(cursor.getString(1));
            user.setEmail(cursor.getString(2));
            user.setPassword(cursor.getString(3));
            user.setHabitsId(Integer.parseInt(cursor.getString(4)));
        }

        db.close();
        return user;
    }

    public Habit readHabit(String title) {
        // get reference of the BookDB database
        SQLiteDatabase db = this.getReadableDatabase();
        Habit habit = new Habit();

        // get user query
        Cursor cursor = db.query(table_HABITS, // a. table
                HABIT_COLUMNS, " title = ?", null, title, null, null, null);

        // if results !=null, parse the first one
        if (cursor != null) {
            cursor.moveToFirst();

            habit.setId(Integer.parseInt(cursor.getString(0)));
            habit.setTitle(cursor.getString(1));
            habit.setDescription(cursor.getString(2));
            habit.setGoal(Integer.parseInt(cursor.getString(3)));
        }

        db.close();
        return habit;
    }

    public ArrayList<Habit> getAllHabitsForUser(User user) {
        ArrayList<Habit> habits = new ArrayList<Habit>();

        int userHabitId = user.getHabitsId();

        // select book query
        String query = "SELECT  * FROM " + table_HABITS + "WHERE habit_user_id = " + userHabitId;

        // get reference of the HabitsDB database
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // parse all results
        Habit habit;
        if (cursor.moveToFirst()) {
            do {
                habit = new Habit();
                habit.setId(Integer.parseInt(cursor.getString(0)));
                habit.setTitle(cursor.getString(1));
                habit.setDescription(cursor.getString(2));
                habit.setGoal(Integer.parseInt(cursor.getString(3)));

                // Add habit to list of habits for this user
                habits.add(habit);
            } while (cursor.moveToNext());
        }
        db.close();
        return habits;
    }

    public int updateUser(User user) {

        // get reference of the HabitsDB database
        SQLiteDatabase db = this.getWritableDatabase();

        // make values to be inserted
        ContentValues values = new ContentValues();
        values.put("username", user.getUsername());
        values.put("email", user.getEmail());
        values.put("password", user.getPassword());

        // update
        int i = db.update(table_USERS, values, user_ID + " = ?", new String[] { String.valueOf(user.getId()) });

        db.close();
        return i;
    }

    // Deleting a single user
    public void deleteUser(User user) {

        // get reference of the HabitsDB database
        SQLiteDatabase db = this.getWritableDatabase();

        // delete user
        db.delete(table_USERS, user_ID + " = ?", new String[] { String.valueOf(user.getId()) });
        db.close();
    }

    // Deleting a single habit
    public void deleteHabit(Habit habit) {

        // get reference of the HabitsDB database
        SQLiteDatabase db = this.getWritableDatabase();

        // delete user
        db.delete(table_HABITS, habit_ID + " = ?", new String[] { String.valueOf(habit.getId()) });
        db.close();
    }
}
