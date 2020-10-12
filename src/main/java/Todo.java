import java.text.SimpleDateFormat;
import java.util.Date;

public class Todo extends Task {

    SimpleDateFormat taskDate = new SimpleDateFormat("dd-MMM-yyyy (E), HH:mm:ss");

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

//    @Override
//    public void markAsDone (Date doneDate){
//
//        this.isDone = true;
//        this.doneDate = doneDate;
//    }

//
//    @Override
//    public Date getEndDate () {
//        return null;
//    }
//
//    @Override
//    public Date getStartDate () {
//        return null;
//    }
//
//    @Override
//    public Date getTargetDate () {
//        return null;
//    }
//
//
//
//    public Date getEndDate () {
//        return null;
//    }
//
//    public Date getStartDate () {
//        return null;
//    }
//    public Date getTargetDate () {
//        return null;
//    }


}