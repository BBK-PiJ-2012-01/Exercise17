package usageExamples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.*;
import java.lang.reflect.Field;

/**
 * Created with IntelliJ IDEA.
 * User: Sam Wright
 * Date: 26/11/2012
 * Time: 15:10
 */
public class UserInputHandlingTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private UserInputHandling obj;

    @Before
    public void setUp() {
        obj = new UserInputHandling();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUp() {
        System.setOut(null);
    }

    @Test
    public void testAverage() throws Exception {
        String faked_input = "";
        for (int i=1; i<=10; ++i) {
            faked_input += String.valueOf(i) + '\n';
        }

        System.setIn(new ByteArrayInputStream(faked_input.getBytes()));
        //obj.printAverageFromUser();

        assertEquals("5", outContent.toString());
    }


}
