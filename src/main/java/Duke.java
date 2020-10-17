
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.text.DateFormat;
import java.util.TimeZone;


public class Duke {

    public static Scanner getInput = new Scanner(System.in);
    private static ArrayList<Task> taskList = new ArrayList<Task>(100);
    private static int num_of_task = 0;
    private static int taskOutstanding = 0;
    protected static int done_item;
    private static String event_details, calender_phrase;
    public static String input;
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

        input = getInput.nextLine();
        //next() place cursor within same line after reading input. nextLine() reads input including space between the words till\n


        while (input != null) {
            if (input.split(" ")[0].equalsIgnoreCase("bye")) {
                System.out.println(dukeDivider);
                System.out.println("\tBye. Hope to see you again soon!");
                System.out.println(dukeDivider);
                break;
            } else if (input.split(" ")[0].equalsIgnoreCase("list")) {

                getTaskList();
                input = getInput.nextLine();

            } else if (input.split(" ")[0].equalsIgnoreCase("todo")) {
                //do something
                try {
                    if (input.substring(4).equals("")) {
                        throw new DukeException();
                    }
                    setTaskList(new Todo(input.substring(5)));
                    input = getInput.nextLine();
                } catch (DukeException e) {
                    System.out.println(dukeDivider);
                    System.out.println("\t☹ OOPS!!! The description of a todo cannot be empty.");
                    System.out.println(dukeDivider);
                    input = getInput.nextLine();
                }
            } else if (input.split(" ")[0].equalsIgnoreCase("deadline")) {

                try {
                    if (input.substring(8).equals("")) {
                        throw new DukeException();
                    } else if (input.substring(8).contains("at")) {
                        throw new Duke_ErrorException();
                    }
                    setTaskList(new Deadline(input.substring(8, input.indexOf("by") - 2), input.substring(input.indexOf("by") + 3)));
                    input = getInput.nextLine();
                } catch (DukeException e) {
                    System.out.println(dukeDivider);
                    System.out.println("\t☹ OOPS!!! The description of a deadline cannot be empty.");
                    System.out.println(dukeDivider);
                    input = getInput.nextLine();
                } catch (Duke_ErrorException e) {
                    System.out.println(dukeDivider);
                    System.out.println("\t OOPS!!! A task deadline must contain keyphrase 'by'.");
                    System.out.println(dukeDivider);
                    input = getInput.nextLine();
                }

            } else if (input.split(" ")[0].equalsIgnoreCase("event")) {
                try {
                    event_details = input.substring(input.indexOf("at") + 3);
                    calender_phrase = input.substring(input.indexOf("at") + 3);

//                  DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
//                            .withResolverStyle(ResolverStyle.STRICT);
//                    LocalDate parsedLocalDate = validateAndParseDateJava8(calender_phrase, dateFormatter);
                    System.out.println(isValidFormat(event_details));
                    if (input.substring(5).equals("")) {
                        throw new DukeException();
                    } else if (input.substring(5).contains("at") && event_details.length() >= 3 && input.substring(5).contains(event_details) && !isValidFormat(event_details)) {

                        for (Calender event : Calender.values()) {
                            if (calender_phrase.equalsIgnoreCase(event.toString())) {
                                setTaskList(new Event(input.substring(5, input.indexOf("at") - 1), event_details));
                                input = getInput.nextLine();
                            }
                            input = getInput.nextLine();
                        }
                        for (Calender event : Calender.values()) {
                            if (!event_details.equalsIgnoreCase(event.toString())) {

                                throw new Duke_Error_EventException();

                            }
                        }
                    } else if (input.substring(5).contains("at") && event_details.length() >= 3 && input.substring(5).contains(event_details) && isValidFormat(event_details)) {

                                String validDate = StrDateFormat(event_details);
                                setTaskList(new Event(input.substring(5, input.indexOf("at") - 1), validDate));
                                input = getInput.nextLine();


                    } else if ((!input.substring(5).contains("at")) && event_details.length() >= 3 && input.substring(5).contains(event_details) && isValidFormat(event_details)) {

                        throw new Duke_ErrorException();

                    } else {

                        throw new Duke_Error_EventException();
                    }

                } catch (DukeException e) {
                    System.out.println(dukeDivider);
                    System.out.println("\t☹ OOPS!!! The description of a event cannot be empty.");
                    System.out.println(dukeDivider);
                    input = getInput.nextLine();
                } catch (Duke_ErrorException e) {
                    System.out.println(dukeDivider);
                    System.out.println("\t OOPS!!! An event must contain keyphrase 'at'.");
                    System.out.println(dukeDivider);
                    input = getInput.nextLine();
                } catch (Duke_Error_EventException e) {
                    System.out.println(dukeDivider);
                    System.out.println("\t OOPS!!! An event must contain a calender phrase (ie: Tue, Sun, Jan, January).");
                    System.out.println(dukeDivider);
                    input = getInput.nextLine();
                }

            } else if (input.split(" ")[0].equalsIgnoreCase("delete")) {

                try {
                    if (input.substring(7).equals("")) {
                        throw new DukeException();
                    }
                    RemoveTask(Integer.parseInt(input.substring(7)) - 1);
                    input = getInput.nextLine();
                } catch (DukeException e) {
                    System.out.println(dukeDivider);
                    System.out.println("\t☹ OOPS!!! The description of number cannot be empty.");
                    System.out.println(dukeDivider);
                    input = getInput.nextLine();
                } catch (NumberFormatException e) {
                    System.out.println(dukeDivider);
                    System.out.println("\t☹ OOPS!!! The description of number must be numeric.");
                    System.out.println(dukeDivider);
                    input = getInput.nextLine();
                }

            } else if (input.split(" ")[0].equalsIgnoreCase("DONE")) {

                try {
                    if (input.substring(4).equals("")) {
                        throw new DukeException();
                    }
                    String task_done = input.split(" ")[1];
                    done_item = Integer.parseInt(task_done) - 1;
                    taskList.get(done_item).markAsDone();
                    input = getInput.nextLine();
                } catch (DukeException e) {
                    System.out.println(dukeDivider);
                    System.out.println("\t☹ OOPS!!! The description of number cannot be empty.");
                    System.out.println(dukeDivider);
                    input = getInput.nextLine();
                } catch (NumberFormatException e) {
                    System.out.println(dukeDivider);
                    System.out.println("\t☹ OOPS!!! The description of number must be numeric.");
                    System.out.println(dukeDivider);
                    input = getInput.nextLine();
                }
            } else {
                System.out.println(dukeDivider);
                System.out.println("\t☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                System.out.println(dukeDivider);
                input = getInput.nextLine();
            }

        }    //end of while loop

    }

    public static void setTaskList(Task description) {
        taskList.add(description);
        System.out.println(dukeDivider);
        System.out.println("\tGot it. I've added this task: ");
//      System.out.println("\t\t"  taskList[num_of_task].getDescription());
        System.out.println("\t\t" + taskList.get(num_of_task).toString());
        num_of_task++;
        System.out.println("\tNow you have " + num_of_task + " tasks in the list.");
        System.out.println(dukeDivider);
    }


    public static void getTaskList() {
        System.out.println(dukeDivider);
        System.out.println("\tHere are the tasks in your list: ");
        for (int i = 0; i < num_of_task; i++) {

            System.out.println("\t" + (i + 1) + taskList.get(i).toString());

        }
        System.out.println(dukeDivider);
    }

    public static void RemoveTask(int Task_idx) {
        taskList.remove(Task_idx);
        System.out.println("\tNow you have " + --num_of_task + " tasks in the list.");
        System.out.println(dukeDivider);
    }

    public static String StrDateFormat(String dateStr) {

//             * Set preferred date format,
//             * For example MM-dd-yyyy, MM.dd.yyyy,dd.MM.yyyy etc.*/
//            SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");

//                DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//                String formattedDate = formatter.format(dateStr);
//                return formattedDate;

//                LocalDate date = LocalDate.now();
//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-M-yyyy");
//                  DateTimeFormatter formatter = DateTimeFormatter.forPattern("yyyy/mm/dd HH:mm:ss");
//                  DateTime dateTime = DateTime.parse(dateStr, formatter);
        String formatted_date=null;

        try {
            DateFormat shortdate = new SimpleDateFormat("yyyy/MM/dd");
            shortdate.setLenient(false);
//            formatted_date = formatter.parse(dateStr);
            formatted_date = shortdate.format(new Date()).toString();

        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format, pls try again.");
            input = getInput.nextLine();
        }
        return formatted_date;

    }


    public static boolean isValidFormat(String dateStr) {

//             * Set preferred date format,
//             * For example MM-dd-yyyy, MM.dd.yyyy,dd.MM.yyyy etc.*/
//            SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd", Locale.US);
//                .withResolverStyle(ResolverStyle.STRICT);
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd", Locale.ENGLISH);
//            sdfrmt.setLenient(false);
            try
            {
                 dateFormatter.parse(dateStr);
//                Date javaDate = sdfrmt.parse(strDate);
//                System.out.println(strDate+" is valid date format");
            }
            /* Date format is invalid */
            catch (DateTimeParseException e)
            {
                System.out.println(dateStr+" is Invalid Date format (ie: yyyy/MM/dd)");
                return false;

            }
            /* Return true if date format is valid */
            return true;
    }

}
//                 isoFormat.setTimeZone.atZone(ZoneId.of("Asia/Singapore"));
//                 Date dateTimeZoned = isoFormat.parse(dateStr);
//
//                DateTimeZone timeZone = DateTimeZone.forID( "Asia/Kolkata" );
//                DateTime dateTimeIndia = new DateTime( input, timeZone );
//                DateTime dateTimeUtcGmt = dateTimeIndia.withZone( DateTimeZone.UTC );

//                String formattedDate = date.format(formatter);
//                LocalDate parsedDate = LocalDate.parse(formattedDate, formatter);
//
//                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//
//                Date date_valid = df.parse(dateStr);
//                Calendar calendar_dte = new GregorianCalendar();
//                calendar_dte.setTime(date_valid);
//                return calendar_dte;


