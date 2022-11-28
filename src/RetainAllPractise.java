// TRAI_22_t09_10_pohja SJ

import java.util.*;

/**
 * Algorithm that gets two unsorted lists A and B (ArrayList in first funtion and on second linkedlist was used) as parameter and
 * removes from list A, every element that does not occur in list B.
 * This was to practice idea of method so retainAll() was not allowed to be used.
 */

public class RetainAllPractise {

    /**
     *
     * @param L1 list where to remove form
     * @param L2 elements to be removed
     */
    public static <E> void retainAllEx9AL(ArrayList<E> L1, ArrayList<E> L2) {
        int i = 0;   // to loop through elements
        int j = 0;
        int L1koko = L1.size(); // copy of L1 size

        HashSet<E> hs = new HashSet<>(L2);// HashSet to remove duplicates

        while (i < L1koko){ //Loop through the array
            if (hs.contains(L1.get(i))){ //if L1 contains same element as in hs --> L2
                L1.set(j++, L1.get(i++)); //retain, element gets moved to start of list
            }
            else
                i++; //only add to i
        }
        while(j < L1.size()){
            L1.remove(L1.size() - 1);
        }
    }

    /**
     *
     * @param L1 list where to remove form
     * @param L2 elements to be removed
     */
    public static <E> void retainAllEx10LL(LinkedList<E> L1, LinkedList<E> L2) {
        HashSet<E> hs = new HashSet<>(L2);

        ListIterator<E> it = L1.listIterator();
        //iterator to loop through linked list
        while(it.hasNext()){
            E i = it.next(); // returns value in front "and jumps over it".
                                // --> next
                                // --> Java deals with, NoSuchElemenExeption();
                                // --> E val = index.data; index = index.next; return val;
            if(!hs.contains(i)){
                it.remove();
            }
        }
    }
} // class