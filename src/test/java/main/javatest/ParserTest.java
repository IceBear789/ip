package main.javatest;

import main.java.DukeException;
import main.java.Parser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ParserTest {

    @Test
    public void ParserEvent() {
        Parser parser = new Parser();
        String[] actual = {"event","Dinner","2019-12-11"};
        try {
            assertEquals(actual[0], parser.processCommand("event Dinner /at 2019-12-11")[0]);
        } catch (DukeException e) {
            System.out.println(e);
        }
    }

    @Test
    public void ParserDeadline() {
        Parser parser = new Parser();
        try {
            assertEquals(null, parser.processCommand("deadline Dinner 2019-12-11"));
            fail();
        } catch (DukeException e) {
            assertEquals(new DukeException("Invalid description of deadline").toString(),e.toString());
        }
    }

    @Test
    public void ParserToDo() {
        Parser parser = new Parser();
        try {
            assertEquals(null, parser.processCommand("todo"));
            fail();
        } catch (DukeException e) {
            assertEquals(new DukeException("Invalid input, description " +
                    "of todo cannot be empty").toString(),e.toString());
        }
    }
}