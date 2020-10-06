import java.text.SimpleDateFormat;
import java.util.Date;




public class Deadline extends Todo {

    protected Date dueDate;
    protected Date addDate;
    protected boolean advance = false;
    protected int timesExtended = 0;

    public Deadline() {
        super();
    }

    public Deadline(String description, Date dueDate, Date addDate) {
        super(description, addDate);
        this.dueDate = dueDate;
        this addDate = addDate;
    }

    public Deadline(String description, Date addDate, Date doneDate,
                    boolean isDone, Date dueDate, boolean advance) {
        super(description, addDate, doneDate, isDone);
        this.advance = advance;
        this.dueDate = dueDate;

    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }


    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean markAsDone(Date doneDate) throws CommandException {
        super.markAsDone(doneDate);
        if(doneDate.compareTo(this.targetDate) < 0) {
            this.doneAhead = true;
        }
        return false;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void printList(){
        System.out.print(this.getTaskIcon());
        System.out.print(this.getStatusIcon() + " ");
        System.out.println(String.format("%s",
                this.getDescription(), "Added: " +
                        taskDate.format(this.getAddDate())));
        System.out.println("\t\t\tDeadline : " +
                taskDate.format(this.getDueDate()));
        if (this.isDone) {
            System.out.println("\t\t\tDone     : " +
                    taskDate.format(this.getDoneDate()) + " " +
                    this.getDoneAhead());
        }
    }

    public String getTaskIcon() {

        return("[D]");
    }

    public String getObjectClass() {
        return "Deadline";
    }

}
