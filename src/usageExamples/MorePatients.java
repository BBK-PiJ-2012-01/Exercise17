package usageExamples;

import sun.tools.jstat.Literal;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sam Wright
 * Date: 26/11/2012
 * Time: 16:40
 */
public class MorePatients {
    List<Patient> lst = new LinkedList<Patient>();

    public void addPatient(String name, int yob) {
        lst.add(new Patient(name, yob));
    }
}

class Patient {
    private final String name;
    private final int yob;

    Patient(String name, int yob) {
        this.name = name;
        this.yob = yob;

        int age = Calendar.getInstance().get(Calendar.YEAR) - yob;
        if (age < 0 || age > 130)
            throw new IllegalArgumentException();
    }
}
