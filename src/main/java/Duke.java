public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
    }

    int taskIndex = Integer.parseInt(input.substring(10)) - 1;
    Task[] tasks = new Task[100];
    int taskCount = 0;
    int taskOutstanding = 0;


    Task t = new Task(input, addDate);
    tasks[taskCount] = t;
    System.out.println(String.format("", "\tAdded: " +
    tasks[taskCount].getDescription(),
                                taskDate.format(tasks[taskCount].getAddDate())));
    taskCount++;
}
