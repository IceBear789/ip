package main.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * The main driver class for Duke. The tasklist contains the task list. The Ui deals
 * with interactions with the user. The parser deals with making sense of the user
 * commands.
 */
public class Duke {
    public TaskList taskList;
    public Parser parser;
    public Ui ui;

    /**
     * The main method of our program. The program terminates with the "bye" command.
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Duke iceBear = new Duke();
        while (true) {
            String nextCommand = scan.nextLine();
            if (nextCommand.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else {
                   try {
                       String[] processedText = iceBear.parser.processCommand(nextCommand);
                       iceBear.process(processedText);
                   } catch (DukeException exception) {
                       System.out.println(exception);
                   }
            }
        }
    }

    /**
     * Constructor for our Dukebot. The Dukebot will always start by first greeting the user
     * whenever it is instantiated.
     */
    public Duke() {
        this.taskList = new TaskList();
        this.parser = new Parser();
        this.ui = new Ui();
        System.out.println("Hello! I'm Icebear");
        System.out.println("What can I do for you?");
    }

    private void process(String[] processedInput) {
        this.ui.processCommand(processedInput, this.taskList);
    }
}