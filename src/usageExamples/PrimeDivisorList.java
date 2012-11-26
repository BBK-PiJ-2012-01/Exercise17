package usageExamples;

/**
 * Created with IntelliJ IDEA.
 * User: Sam Wright
 * Date: 26/11/2012
 * Time: 15:44
 */
public interface PrimeDivisorList {

    /**
     * Adds an Integer to the list, unless it is null
     * (where it throws a NullPointerException) or it
     * is not a prime number (where it throws an
     * IllegalArgumentException).
     *
     * @param val The value to add
     */
    void add(Integer val);

    /**
     * Remove the Integer if it's in the list.  If it
     * doesn't exist, do nothing.  If more than one exist,
     * only remove one.
     *
     * @param val The value to remove.
     */
    void remove(Integer val);

    /**
     * Returns a string representing the equation for
     * multiplying all the prime numbers together.
     *
     * @return String representation.
     */
    String toString();
}
