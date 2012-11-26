package usageExamples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: Sam Wright
 * Date: 26/11/2012
 * Time: 15:02
 */
public class UserInputHandling {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void printAverageFromUser() {
        int total = 0;

        String input;
        for (int i=0; i<10; ++i) {
            try {
                System.out.println("getting line " + 1);
                input = br.readLine();
                total += Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                System.out.println("That wasn't an integer! Try again...");
                --i;
                continue;
            } catch (IOException ex) {
                throw new RuntimeException("Couln't get input. IO problem?");
            }
        }

        //System.out.println(((double) total)/10);
    }
}
