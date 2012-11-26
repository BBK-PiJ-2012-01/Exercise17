package usageExamples;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: Sam Wright
 * Date: 26/11/2012
 * Time: 16:45
 */
public class MorePatientsTest {
    MorePatients lst;

    @Before
    public void setUp() {
        lst = new MorePatients();
    }

    @Test
    public void testAddPatient() throws Exception {
        lst.addPatient("Bob", 2000);
    }

    @Test
    public void testAddPatientTooYoung() throws Exception {
        try {
            lst.addPatient("Bob", 2020);
        } catch (IllegalArgumentException ex) {
            return;
        }
        fail("Was able to add person under 0");
    }

    @Test
    public void testAddPatientToOld() throws Exception {
        try {
            lst.addPatient("Bob", 1881);
        } catch (IllegalArgumentException ex) {
            return;
        }
        fail("Was able to add person over 130");
    }
}
