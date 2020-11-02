/**
 * This class is to read user command and print error.
 *
 * @author ANG KUO SHENG CLEMENT
 * @version 2020.11.11
 * @since TaskScheduler lvl 1
 */
package main.java;
import java.util.Scanner;


public class Ui {
    public static Scanner getInput = new Scanner(System.in);
    public static String dukeDivider = "-------------------------------------------------------------------------------------";

    /**
     * Ui command entity .
     */
    public Ui() {
    }

    /**
     * This function is to get user command.
     *
     * @return user command
     */
    public String readUserCommand() {
        System.out.println(System.lineSeparator() + "Enter the task you would like to do? ");
        String command=getInput.nextLine().trim();
        return command;
    }

    /**
     * This function is to read user new command that its user want edit to.
     *
     * @return user new command
     */
    public String readNewCommand() {
        System.out.println("Please key in New Task: ");
        String command=getInput.nextLine().trim();
        return command.toLowerCase();
    }

    /**
     * This function is show welcome message to user.
     */
    public void showWelcomeMessage() {
        System.out.println("\t" +
                "Welcome to TaskScheduler Application!");
        System.out.println(dukeDivider);
        System.out.println("\tHello! I'm Duke");
        System.out.println("\tWhat can I do for you?");
        System.out.println(dukeDivider);
    }

    public void showToUser(String s) {
        System.out.println(s);
    }

    public static String showError() {
        System.out.println("Unknown command! Please re-enter again.");
        String command=getInput.nextLine().trim();
        return command;
    }

    public static String showError(String message) {
        System.out.println(message);
        String command=getInput.nextLine().trim();
        return command;
    }

    /**
     * This function is indicate to user when exit with basic text (ie: bye etc").
     */
    public void exit() {

        System.out.println("\tBye. Hope that use can use this TaskScheduler to help you again!");


    }

    public void showHelp() {
        System.out.println("help       show to user all command and instructions" + System.lineSeparator()
                + "           e.g.  help" + System.lineSeparator()
                + "print      print all tasks or any one task" + System.lineSeparator()
                + "           e.g.  print all" + System.lineSeparator()
                + "           e.g.  print 1" + System.lineSeparator()
                + "todo       add todo task in user TaskScheduler" + System.lineSeparator()
                + "           e.g.  todo swimming" + System.lineSeparator()
                + "deadline   add task with deadline use command '/by' in user TaskScheduler" + System.lineSeparator()
                + "           e.g.  deadline swimming /by sunday" + System.lineSeparator()
                + "done       mark any task as done in user TaskScheduler" + System.lineSeparator()
                + "           e.g.  done 1" + System.lineSeparator()
                + "edit       edit any task in user TaskScheduler" + System.lineSeparator()
                + "           e.g.  edit 1" + System.lineSeparator()
                + "search     search any task in user TaskScheduler with a keyword" + System.lineSeparator()
                + "           e.g.  search sunday" + System.lineSeparator()
                + "sort       sorting user TaskManager by completed status and deadline time" + System.lineSeparator()
                + "           e.g.  sort" + System.lineSeparator()
                + "delete     delete any task in user TaskScheduler" + System.lineSeparator()
                + "           e.g.  delete 1" + System.lineSeparator()
                + "clear      clear user TaskManager, delete everything inside" + System.lineSeparator()
                + "           e.g.  clear" + System.lineSeparator()
                + "save       save user tasks in user TaskScheduler" + System.lineSeparator()
                + "           e.g.  save" + System.lineSeparator()
                + "exit       exit from TaskScheduler" + System.lineSeparator()
                + "           e.g.  exit" + System.lineSeparator());
    }
}
