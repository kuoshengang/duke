
import java.util.Date;

public class Task {
    protected String description;
    protected Date addDate;
    protected Date doneDate;

    protected boolean isDone;

    public Task(String description, Date addDate) {
        this.addDate = addDate;
        this.isDone = false;
        this.description = description;

    }

    public Date getAddDate() {
        return (this.addDate);
    }

    public Date getDoneDate() {
        return (this.doneDate);
    }

    public String getDescription() {
        return (this.description.toString());

    }

    public String getStatusIcon() {
        if(this.isDone){
            return ("[\u2713]");
        } else {
            return ("[\u2718]");
        }
    }

    public void markAsDone(Date doneDate) {
        this.isDone = true;
        this.doneDate = doneDate;
    }
}