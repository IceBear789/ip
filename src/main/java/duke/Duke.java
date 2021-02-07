package duke;
import java.util.Scanner;


/**
 * The main driver class for Dukebot.
 */
class Duke {
    // Contains the task list, with operations to add/delete tasks.
    private TaskList taskList;
    // Deals with making sense of the user command.
    private Parser parser;
    // Deals with interactions with the user.
    private Ui ui;

    /**
     * Constructor for our Dukebot. The Dukebot will always start by first greeting the user
     * whenever it is instantiated.
     */
    public Duke() {
        this.taskList = new TaskList();
        this.parser = new Parser();
        this.ui = new Ui();
        System.out.println(this.greet());
    }

    /**
     * The main driver method to test our program. The method terminates with the "bye" command.
     *
     * @param args the user input
     * @throws Exception the program terminates when an exception is thrown
     */
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Duke iceBear = new Duke();
        while (true) {
            String nextCommand = scan.nextLine();
            if (nextCommand.equals("bye")) {
                System.out.println(iceBear.exit());
                break;
            }
            try {
                System.out.println(iceBear.process(nextCommand));
            } catch (DukeException exception) {
                System.out.println(exception);
            }
        }
    }
    private String greet() {
        String greetingMessage = "Hello! I'm Icebear\nWhat can I do for you?";
        return greetingMessage;
    }
    private String exit() {
        String farewellMessage = "Bye. Hope to see you again soon!";
        return farewellMessage;
    }
    private String process(String input) throws DukeException {
        String[] parsedCommand = this.parser.parseCommand(input);
        return this.ui.processCommand(parsedCommand, this.taskList);
    }
    public String getResponse(String input) {
        Duke iceBear = new Duke();
        if (input.equals("bye")) {
            return "Bye. Hope to see you again soon!";
        }
        try {
            return iceBear.process(input);
        } catch (DukeException exception) {
            return exception.toString();
        }
    }
}
