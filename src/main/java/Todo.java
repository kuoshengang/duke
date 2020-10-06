import java.text.SimpleDateFormat;
import java.util.Date;

public class Todo extends Task {

    SimpleDateFormat taskDate = new SimpleDateFormat("dd-MMM-yyyy");

    public Todo(String description, Date Dateadded) {

        super(description, Dateadded);
    }

    public String getTaskIcon() {
        public void printList () {

            System.out.print(this.getStatusIcon() + " ");
            System.out.println(String.format("%1$-30s%2$29s",
                    this.getDescription(), "Added: " +
                            taskDate.format(this.getAddDate())));
            System.out.print(this.getTaskIcon());
            if (this.isDone) {
                System.out.println("\t\t\tDone     : " +
                        taskDate.format(this.getDoneDate()));
            }
        }

        public String getTaskIcon () {
            return ("[T]");
        }

        @Override
        public void markAsDone (Date doneDate){

            this.isDone = true;
            this.doneDate = doneDate;
        }



        @Override
        public Date getEndDate () {
            return null;
        }


        @Override
        public Date getStartDate () {
            return null;
        }

        @Override
        public Date getTargetDate () {
            return null;
        }


        @Override
        public void markAsDone (Date doneDate, Double itemPrice){

        }
        public String getDoneAhead () {
            return null;
        }
        public long getDurationMinutes () {
            return 0;
        }
        public Date getEndDate () {
            return null;
        }
        
        public Date getStartDate () {
            return null;
        }
        public Date getTargetDate () {
            return null;
        }

        public void markAsDone (Date doneDate, Double itemPrice){
        }
    }
}