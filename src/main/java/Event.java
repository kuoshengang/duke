import java.text.SimpleDateFormat;
import java.util.Date;

public class Event extends Task {

    protected String at;

    SimpleDateFormat taskDate = new SimpleDateFormat("dd-MMM-yyyy (E), HH:mm:ss");
    protected Date startDate;
    protected Date endDate;
    protected long durationMinutes;


//    public Event(String description, Date startDate, Date endDate, Date addDate) {
//
//        super(description, addDate);
//        this.startDate = startDate;
//        this.endDate = endDate;
//        this.durationMinutes = (endDate.getTime() - startDate.getTime())/60000;
//    }

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    public String getDescription() {
        return "[E]" + super.getDescription() + " (at: " + at + ")";
    }

    public void setEndDate(Date endDate) {

        this.endDate = endDate;
    }

    public void setStartDate(Date startDate) {

        this.startDate = startDate;
    }



    public void printList(){
        System.out.print(this.getTaskIcon());
        System.out.print(this.getStatusIcon() + " ");
        System.out.println(String.format("%s",
                this.getDescription() + " (" +
                        this.getDuration() +
                        "mins)", "Added: " +
                        taskDate.format(this.getAddDate())));
        System.out.println("\t\t\tFrom     : " +
                taskDate.format(this.getStartDate()));
        System.out.println("\t\t\tTo       : " +
                taskDate.format(this.getEndDate()));
        if (this.isDone) {
            System.out.println("\t\t\tDone     : " +
                    taskDate.format(this.getDoneDate()));
        }
    }

    public Date getStartDate() {
        return (this.startDate);
    }

    public Date getEndDate() {

        return (this.endDate);
    }

    public long getDuration() {

        return (this.durationMinutes);
    }

    public String getTaskIcon() {

        return("[E]");
    }


//    @Override
//    public Date getTargetDate() {
//        return null;
//    }

//    @Override
//    public void markAsDone(Date doneDate, Double itemPrice){
//
//    }
//    public void markAsDone(Date doneDate, Double itemPrice){ }
//

}