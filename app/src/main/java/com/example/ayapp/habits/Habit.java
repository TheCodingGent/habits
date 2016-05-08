package com.example.ayapp.habits;

/**
 * Created by amoughnie on 07-May-16.
 */
public class Habit {

    /***********************************************************************************************
     * VARIABLES
     * ********************************************************************************************/
     // Private instance variables
    private String title;
    private String description;
    private int goal;// number of days in which you want to preform this habit
    private int id;

    /***********************************************************************************************
     * CONSTRUCTORS
     * ********************************************************************************************/
    public Habit(){
        this.title = null;
        this.description = null;
        this.goal = 0;
        this.id = 0;
    }
    
    public Habit(String title,String description, int goal, int id){
        this.title = title;
        this.description = description;
        this.goal = goal;
        this.id = id;
    }

    /***********************************************************************************************
     * SETTERS AND GETTERS
     * ********************************************************************************************/
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    /***********************************************************************************************
     * UTILITY METHODS
     *********************************************************************************************/
      @Override
      public String toString() {
        return "Habit [Title= " + title + ", Description= " + description + ", Goal= " + goal + 
         ", ID= " + id + "]";
      }
    
}
