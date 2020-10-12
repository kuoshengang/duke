import java.text.SimpleDateFormat;
import java.util.Date;



public class Deadline extends Todo {

    protected String dueDate;
//    protected boolean advance = false;
//    protected int timesExtended = 0;


    public Deadline(String description,  String dueDate) {
        super(description);
        this.dueDate = dueDate;

    }

//    public Deadline(String description, Date addDate, Date doneDate,
//                    boolean isDone, Date dueDate) {
//        super(description, addDate, doneDate, isDone);
//        this.dueDate = dueDate;
//
//    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + dueDate + ")";
    }


    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

//    public boolean markAsDone(String doneDate) {
//        super.markAsDone(doneDate);
//        if(doneDate.compareTo(this.dueDate) < 0) {
//            this.doneAhead = true;
//        }
//        return false;
//    }

    public String getDueDate() {
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
                    this.getDoneDate());
        }
    }

    public String getTaskIcon() {

        return("[D]");
    }

//    public String getObjectClass() {
//        return "Deadline";
//    }

}
