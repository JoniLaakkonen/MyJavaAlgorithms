import java.util.LinkedList;
import java.util.ListIterator;


public class removeDublicatesComingRightAfter {
    /**
     * Removes dublicates from a list if it occurs right after the element for example-> (A,A).
     * @param L muokattava lista
     * @param <E> alkiotyyppi
     */
    static public <E> void removeDublicates(LinkedList<E> L) {

        //from lists with less than 2 elements --> do nothing
        if (L.size() < 2)
            return;

        // TODO
        ListIterator<E> li = L.listIterator();
        E before = null; //element to compare with (null if on the first element of the list)
        while (li.hasNext()){
            E x = li.next();
        if(x.equals(before)) {//if same as element before it
            // then remove it
            li.remove();
        }
        else
            before = x;
        }
    }
}