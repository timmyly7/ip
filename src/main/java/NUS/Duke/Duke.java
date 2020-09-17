package NUS.Duke;

import NUS.Duke.DTO.TaskDTO;
import NUS.Duke.ProcessingException;
import NUS.Duke.utils.ParserUtil;
import NUS.Duke.utils.UI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        UI ui = new UI();
        UI.printWelcomeMessage();
        String command = ui.readCommand();

        while (!ParserUtil.getFunctionCommand(command).equals("bye")) {
            processCommand(command);
            command = ui.readCommand();
        }

    }



    public static void processCommand(String originalCommand) {
        System.out.println("____________________________________________________________");
        String operation = ParserUtil.getFunctionCommand(originalCommand);
        String details = originalCommand.substring(originalCommand.indexOf(' ') + 1);


        switch (operation){
            case "todo":
                ParserUtil.createTodoTask(details);
                break;
            case "deadline":
                ParserUtil.createDeadlineTask(details);
                break;
            case "event":
                try {
                    ParserUtil.createEventTask(details);
                } catch (ProcessingException e) {
                    e.printStackTrace();
                }
                break;
            case "list":
                UI.printList(ParserUtil.taskList);
                break;
            case "bye":
                UI.printByeMessage();
                System.exit(0);
                break;
            case "done":
                ParserUtil.doneTask(Integer.parseInt(details));
                break;
            case "delete":
                ParserUtil.deleteTask(Integer.parseInt(details));
                break;
            case "save":
                ParserUtil.writeToFile();
                break;
            case "find":
                ParserUtil.findTask(details);
                break;
            default:
                UI.printErrorMessage("Sorry i dont understand the command");

        }

        System.out.println("____________________________________________________________");
    }


}
