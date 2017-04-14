package mobi.roomies.models;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by kolten on 12/2/16.
 */

public class Task {

    String title;
    String createdBy;
    Calendar due;
    int priority;

    private String type; // Use this to determine what type of buttons need to be rendered?

    public Task(){

    }

    public Task(String title, String createdBy, int priority){
        this.title = title;
        this.createdBy = createdBy;
        this.priority = priority;
        // Handle a calendar object here
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriortiy(int priority){
        this.priority = priority;
    }
}
