import org.junit.Before;
import org.junit.Test;

/**
* Created with IntelliJ IDEA.
* User: Sam Wright
* Date: 26/11/2012
* Time: 14:42
*/
public class CodeFlowTest {
    private CodeFlow obj;

    @Before
    public void setUp() throws Exception {
        obj = new CodeFlow();
    }

    @Test
    public void testLaunch1() throws Exception {
        System.out.println("\nInput = 0");
        obj.launch(0);

        System.out.println("\nInput = 2");
        obj.launch(2);

        System.out.println("\nInput = 4");
        obj.launch(4);

        System.out.println("\nInput = 6");
        obj.launch(6);
    }
}
