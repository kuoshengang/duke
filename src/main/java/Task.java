/**
 * This class to create task object.
 *
 * @author ANG KUO SHENG CLEMENT
 * @version 2020.11.11
 * @since TaskScheduler lvl1
 */

import java.util.Date;

public class Task {
    public String description;
    protected Date addDate;
    protected String doneDate;
    protected boolean isDone;

    String TaskDivider = "\t----------------------------------------------------------------------------";

    public Task(String description) {
        this.description = description;
    }

    public String getDoneDate() {

        return (this.doneDate);
    }

    public String getDescription() {

        return this.description;
    }

    public String toString() {

        return "" + getStatusIcon() + "" + this.description;
    }

    public String getStatusIcon() {
        if(this.isDone){
            return ("[\u2713]");
        } else {
            return ("[\u2718]");
        }
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    public void markAsDone() {
        this.isDone = true;
        System.out.println(TaskDivider);
        System.out.println("\tNice! I've marked this task as done: ");
        System.out.println("\t" + getStatusIcon() + this.description ); //ticked symbols
        System.out.println(TaskDivider);
    }
}