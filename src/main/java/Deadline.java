/**
 * This class to create Deadline object.
 *
 * @author ANG KUO SHENG CLEMENT
 * @version 2020.11.11
 * @since TaskScheduler lvl1
 */

import java.text.SimpleDateFormat;
import java.util.Date;
package main.java;

public class Deadline extends Todo {

    protected String dueDate;

    public Deadline(String description,  String dueDate) {
        super(description);
        this.dueDate = dueDate;

    }


    @Override
    public String toString() {
        return  super.toString() + " (by: " + dueDate + ")";
    }


    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }


    public String getDueDate() {
        return dueDate;
    }


    public String getTaskIcon() {

        return("[D]");
    }


}
