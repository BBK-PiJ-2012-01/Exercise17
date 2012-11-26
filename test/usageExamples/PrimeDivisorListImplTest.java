package usageExamples;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Sam Wright
 * Date: 26/11/2012
 * Time: 15:51
 */
public class PrimeDivisorListImplTest {
    private PrimeDivisorList obj;
    private static List<Integer> primes;
    private static List<Integer> non_primes;
    private List<Integer> obj_primes;

    static {
        Integer[] temp_primes = new Integer[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};
        primes = new LinkedList<Integer>(Arrays.asList(temp_primes));
        non_primes = new LinkedList<Integer>();

        for (int i = temp_primes[0]; i > temp_primes[temp_primes.length-2]; ++i) {
            for (int j = i; j < temp_primes[i+1]; ++j) {
                non_primes.add(j);
            }
        }
    }

    @Before
    public void setUp() throws Exception {
        obj = new PrimeDivisorListImpl();

        Field lst_field = null;

        try {
            lst_field = PrimeDivisorListImpl.class.getField("primes");

        } catch (NoSuchFieldException e) {
            Field fields[] = PrimeDivisorListImpl.class.getDeclaredFields();
            for (Field field : fields) {
                if (field.getName().equals("primes"))
                    lst_field = field;
            }
            if (lst_field == null)
                throw new RuntimeException("Couldn't find primes list from class");
        }

        lst_field.setAccessible(true);

        try {
            obj_primes = (List<Integer>) lst_field.get(obj);
        } catch (IllegalAccessException ex) {
            throw new RuntimeException("Couldn't access primes list from class");
        }
    }

    @Test
    public void testAddPrime() throws Exception {
        for (int prime : primes) {
            obj.add(prime);
        }

        for (int prime : primes) {
            assertTrue(lstContains(prime));
        }
    }

    @Test
    public void testAddNonPrime() throws Exception {
        for (int non_prime : non_primes) {
            try {
                obj.add(non_prime);
            } catch (IllegalArgumentException ex) {
                return;
            }
            fail("Was able to add " + non_prime);
        }

        for (int non_prime : non_primes) {
            assertFalse(lstContains(non_prime));
        }
    }

    @Test
    public void testAddNull() throws Exception {
        try {
            obj.add(null);
        } catch (NullPointerException e) {
            return;
        }
        fail("Was able to add null");
    }

    @Test
    public void testRemoveNotAdded() throws Exception {
        obj.remove(4);
    }

    @Test
    public void testRemoveNull() throws Exception {
        obj.remove(null);
    }

    @Test
    public void testRemoveAdded() throws Exception {
        obj.add(2);
        obj.add(3);
        assertTrue(lstContains(3));
        obj.remove(3);
        assertFalse(lstContains(3));
    }

    private boolean lstContains(int val) {
        for (int prime : obj_primes) {
            if (val == prime)
                return true;
        }
        return false;
    }

    @Test
    public void testToString() {
        obj.add(2);
        obj.add(3);
        obj.add(3);
        assertEquals("[ 2 * 3^2 = 18 ]", obj.toString());
    }

    @Test
    public void testEmptyToString() {
        assertEquals("[]", obj.toString());
    }

}
