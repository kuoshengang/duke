import java.text.SimpleDateFormat;
import java.util.Date;

public class Event extends Task {


    SimpleDateFormat taskDate = new SimpleDateFormat("dd-MMM-yyyy (E)");
    protected Date startDate;
    protected Date endDate;
    protected long durationMinutes;


    public Event(String description, Date startDate, Date endDate, Date addDate) {

        super(description, addDate);
        this.startDate = startDate;
        this.endDate = endDate;
        this.durationMinutes = (endDate.getTime() - startDate.getTime())/60000;
    }


    public void setStartDate(Date startDate) {

        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {

        this.endDate = endDate;
    }

    //GET STATEMENTS------------------------------------
    public Date getStartDate() {
        public void printList(){
            System.out.print(this.getTaskIcon());
            System.out.print(this.getStatusIcon() + " ");
            System.out.println(String.format("%1$-30s%2$29s",
                    this.getDescription() + " (" +
                            this.getDurationMinutes() +
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

        public long getDurationMinutes() {

            return (this.durationMinutes);
        }

        public String getTaskIcon() {

            return("[E]");
        }

        public String getTaskIcon() { }
        public String getDoneAhead() {
            return null;
        }

        @Override
        public Double getItemBudget() {
            return null;
        }

        @Override
        public Double getItemPrice() {
            return null;
        }

        @Override
        public Date getTargetDate() {
            return null;
        }

        @Override
        public void markAsDone(Date doneDate, Double itemPrice){

        }
        public void markAsDone(Date doneDate, Double itemPrice){ }


        }