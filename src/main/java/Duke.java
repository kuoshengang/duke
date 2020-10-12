import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Duke {
    static Scanner getInput = new Scanner(System.in);
    private static Task[] taskList = new Task[100];
    private static int num_of_task = 0;
    private static int taskOutstanding = 0;
    Date now = new Date();


    public static String dukeDivider = "\t----------------------------------------------------------------------------";

    public static void main(String[] args) {

        SimpleDateFormat taskDate = new SimpleDateFormat("dd-MMM-yyyy (E), HH:mm:ss");
        SimpleDateFormat inputDate = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("\n Welcome to Task Organizer App - 2020\n" + logo);


        //    int taskIndex = Integer.parseInt(input.substring(10) - 1);
        System.out.println(dukeDivider);
        System.out.println("\tHello! I'm Duke");
        System.out.println("\tWhat can I do for you?");
        System.out.println(dukeDivider);

        String input = getInput.nextLine();
        //next() place cursor within same line after reading input. nextLine() reads input including space between the words till\n


        while (input != null) {
            if (input.split(" ")[0].equals("bye")) {
                System.out.println(dukeDivider);
                System.out.println("\tBye. Hope to see you again soon!");
                System.out.println(dukeDivider);
                break;
            }else if (input.split(" ")[0].equals("list")) {
                getTaskList();
                input = getInput.nextLine();
            }
//            else if (input.split(" ")[0].equals("done")){
//                String done = input.split(" ")[1];
//                //itIsDone(Integer.parseInt(input.split(" ")[1])-1); //have to minus 1, because added 1 before
//                num_of_task = num_of_task-1;
//                taskList[num_of_task].markAsDone();
//                input = getInput.nextLine();
//            }
            else if (input.split(" ")[0].equals("todo")){
                //do something
                Date addDate = new Date();
                setTaskList(new Todo(input.substring(4)));
                input = getInput.nextLine();
            }else if (input.split(" ")[0].equals("deadline")){

                setTaskList(new Deadline( input.substring(8, input.indexOf("by")-2), input.substring(input.indexOf("by")+3) ));
                input = getInput.nextLine();
            }else if (input.split(" ")[0].equals("event") ){
                setTaskList(new Event(input.substring(5, input.indexOf("at")-2), input.substring(input.indexOf("at")+3) ));
                input = getInput.nextLine();
            }

       }

    }
    public static void setTaskList(Task description){
        taskList[num_of_task] = description;
        System.out.println(dukeDivider);
        System.out.println("\tGot it. I've added this task: ");
        System.out.println("\t\t" + taskList[num_of_task].getStatusIcon() + taskList[num_of_task].getDescription());
        num_of_task++;
        System.out.println("\tNow you have " + num_of_task + " tasks in the list.");
        System.out.println(dukeDivider);
    }


    public static void getTaskList(){
        System.out.println(dukeDivider);
        System.out.println("\tHere are the tasks in your list: ");
        for (int i = 0; i< num_of_task; i++){
            System.out.println("\t" + (i+1) + ". ["  +taskList[i].getStatusIcon()+ "]" +taskList[i].getDescription());
            System.out.println("\t" + (i+1) + ". " +taskList[i].getDescription());
        }
        System.out.println(dukeDivider);
    }

}
//    Task t = new Task(input, addDate);
//    tasks[num_of_task] = t;
//    System.out.println(String.format("", "\tAdded: " + tasks[num_of_task].getDescription()) );
////           taskDate.format(tasks[num_of_task].getAddDate()));
//    num_of_task++;

