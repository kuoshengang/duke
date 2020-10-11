import java.text.SimpleDateFormat;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("\n Welcome to Task Organizer App\n" + logo);
    }
    SimpleDateFormat taskDate = new SimpleDateFormat("dd-MMM-yyyy (E), HH:mm:ss");
    Date now = new Date();
    String dukeDivider = "\t----------------------------------------------------------------------------";

    //    int taskIndex = Integer.parseInt(input.substring(10) - 1);
    private static Task[] taskList = new Task[100];
    private static int num_of_task = 0;
    private static int taskOutstanding = 0;


    String input = getInput.nextLine();
    //next() place cursor within same line after reading input. nextLine() reads input including space between the words till\n


    while (input != null) {
        if (input.equals("bye")) {
            System.out.println(dukeDivider);
            System.out.println("\tBye. Hope to see you again soon!");
            System.out.println(dukeDivider);
            break;
        } else if (input.split(" ")[0].equals("list")) {
            getTaskList();
            break;
            input = getInput.nextLine();
        } else if (input.split(" ")[0].equals("done") ){
            String done = input.split(" ")[1];
            //itIsDone(Integer.parseInt(input.split(" ")[1])-1); //have to minus 1, because added 1 before
            itIsDone(Integer.parseInt(done)-1);
            break;
            input = getInput.nextLine();
        }else if (input.split(" ")[0].equals("todo") ){
            //do something
            Date addDate = new Date();
            setTaskList(new Task(input, addDate));
            System.out.println(dukeDivider);

            System.out.println("\tGot it. I've added this task: ");
            System.out.println("\t\t[T]" + "[" + "\u2718" + "] " + input.split(" ")[1]);
            System.out.println("\tNow you have " + numberOfTask + " tasks in the list.");
            System.out.println(dukeDivider);
            setTaskList(new Todo(input.substring(4)),addDate);
            input = getInput.nextLine();
        }else if (input.split(" ")[0].equals("deadline") ){
            setTaskList(new Deadline(input.substring(8, input.indexOf("by")-2), input.substring(input.indexOf("by")+3)));
            input = getInput.nextLine();
        }else if (input.split(" ")[0].equals("event") ){
            setTaskList(new Event(input.substring(5, input.indexOf("at")-2), input.substring(input.indexOf("at")+3)));
            input = getInput.nextLine();
        }

    }

    public static void setTaskList(Task description){
        taskList[num_of_task] = description;
        System.out.println(dukeDivider);
        System.out.println("\tGot it. I've added this task: ");
        System.out.println("\t\t" + taskList[num_of_task].getDescription());
        num_of_task++;
        System.out.println("\tNow you have " + num_of_task + " tasks in the list.");
        System.out.println(dukeDivider);
    }

    //list
    public static void getTaskList(){
        System.out.println(dukeDivider);
        System.out.println("\tHere are the tasks list: ");
        for (int i = 0; i< numberOfTask; i++){
            System.out.println("\t" + (i+1) + ". ["  +taskList[i].getStatusIcon()+ "]" +taskList[i].getDescription());
            System.out.println("\t" + (i+1) + ". " +taskList[i].getDescription());
        }
        System.out.println(dukeDivider);
    }


//    Task t = new Task(input, addDate);
//    tasks[num_of_task] = t;
//    System.out.println(String.format("", "\tAdded: " + tasks[num_of_task].getDescription()) );
////           taskDate.format(tasks[num_of_task].getAddDate()));
//    num_of_task++;
}
