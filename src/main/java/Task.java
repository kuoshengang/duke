
import java.util.Date;

public class Task {
    public String description;
    protected Date addDate;
    protected String doneDate;
    protected boolean isDone;

    String TaskDivider = "\t----------------------------------------------------------------------------";

    public Task(String description) {
//        this.addDate = addDate;
        this.isDone = false;
        this.description = description;

    }

    public Date getAddDate() {

        return (this.addDate);
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

    public void markAsDone() {
        this.isDone = true;
//        this.doneDate = doneDate;
        System.out.println(TaskDivider);
        System.out.println("\tNice! I've marked this task as done: ");
        System.out.println("\t" + getStatusIcon() + this.description ); //ticked symbols
        System.out.println(TaskDivider);
    }
}