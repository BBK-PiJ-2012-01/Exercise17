import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sam Wright
 * Date: 26/11/2012
 * Time: 14:47
 */
public class ExceptionOrdering {

    public <T> void badOrdering(List<T> list, T newElement) {
        /*
        try {
            // more code here
            list.add(newElement);
            // more code here;
        } catch (Exception ex) {
            ex.printStackTrace();
        } catch(NullPointerException ex) {
            ex.printStackTrace();
        }
        */
    }

    public <T> void goodOrdering(List<T> list, T newElement) {
        try {
            // more code here
            list.add(newElement);
            // more code here;
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
