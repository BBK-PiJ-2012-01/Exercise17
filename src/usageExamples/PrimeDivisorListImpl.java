package usageExamples;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Sam Wright
 * Date: 26/11/2012
 * Time: 15:51
 */
public class PrimeDivisorListImpl implements PrimeDivisorList {
    private final List<Integer> primes = new LinkedList<Integer>();

    @Override
    public void add(Integer val) {
        if (val == null)
            throw new NullPointerException();

        if (isPrime(val))
            primes.add(val);

    }

    private boolean isPrime(int val) {
        if (val < 2)
            return false;

        for (int i=2; i<val/2; ++i) {
            if (val % i == 0)
                return false;
        }

        return true;
    }

    @Override
    public void remove(Integer val) {
        if (val == null)
            return;

        for (Integer prime : primes) {
            if (prime.equals(val)) {
                primes.remove(prime);
                return;
            }
        }
    }

    @Override
    public String toString() {
        Map<Integer, Integer> occurances = new HashMap<Integer, Integer>();
        int total = 1;

        for (Integer prime : primes) {
            if (occurances.containsKey(prime)) {
                occurances.put(prime, occurances.get(prime) + 1);
            } else {
                occurances.put(prime, 1);
            }
            total *= prime;
        }

        if (occurances.isEmpty())
            return "[]";

        StringBuilder sbuf = new StringBuilder();
        boolean is_first = true;
        for (Map.Entry<Integer,Integer> e : occurances.entrySet()) {
            if (is_first) {
                sbuf.append("[ ");
                is_first = false;
            } else {
                sbuf.append(" * ");
            }

            sbuf.append(e.getKey().toString());

            if (!e.getValue().equals(1)) {
                sbuf.append('^');
                sbuf.append(e.getValue().toString());
            }
        }

        sbuf.append(" = ");
        sbuf.append(total);
        sbuf.append(" ]");

        return sbuf.toString();
    }
}
