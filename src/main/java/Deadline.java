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


    public void setTargetDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean markAsDone(Date doneDate) throws CommandException {
        super.markAsDone(doneDate);
        if(doneDate.compareTo(this.targetDate) < 0) {
            this.doneAhead = true;
        }
        return false;
    }

    public Date getTargetDate() {
        return dueDate;
    }

    public void printDetails(){
        System.out.print("\t\t\tDeadline : " +
                TASK_DATE.format(this.targetDate));
        if(this.timesExtended > 0){
            System.out.println("(" + this.timesExtended +
                    " extensions)");
            System.out.print("(" + this.timesExtended +
                    " extensions)\n");
        } else {
            System.out.println("");
            System.out.print("\n");
        }
        if (this.isDone) {
            System.out.println("\t\t\tDone     : " +
            @@ -97,7 +97,7 @@ public String getSaveText() {
                this.description.toString() + "/" +
                        INPUT_DATE.format(this.addDate) + "/" +
                        this.isDone + "/" +
                        this.targetDate + "/" +
                        INPUT_DATE.format(this.targetDate) + "/" +
                        this.doneAhead;

                if(isDone) {
                    text = text + "/" + INPUT_DATE.format(this.doneDate) + "\n";
                } else {
                    text = text + "\n";
                }
                return text;
            }

            public String getTaskIcon() {

                return("[D]");
            }

            public String getObjectClass() {
                return "Deadline";
            }

        }
    }
}