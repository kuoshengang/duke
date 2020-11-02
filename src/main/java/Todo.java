/**
 * This class to create Todo object.
 *
 * @author ANG KUO SHENG CLEMENT
 * @version 2020.11.11
 * @since TaskScheduler lvl1
 */

package main.java;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Todo extends Task {

    public Todo(String description) {

        super(description);
    }

    public void printList () {

        System.out.print(this.getStatusIcon() + " ");
        System.out.println(String.format("%s",
                super.getDescription()));
        System.out.print(this.getTaskIcon());
//        if (this.isDone) {
//            System.out.println("\t\t\tDone     : " +
//                    taskDate.format(this.getDoneDate()));
//        }
    }

    public String toString() {
        return getTaskIcon() + super.toString();
    }

    public String getTaskIcon() {
        return ("[T]");
    }



}