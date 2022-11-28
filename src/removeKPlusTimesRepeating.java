import java.util.*;


/**
 * Simple program to remove every element from list, if element occur more than k times in that list
 *
 * Time complexity O(n logn).
 */
public class removeKPlusTimesRepeating {
    public <E> void removeKPlusTimesRepeating(ArrayList<E> L, int k) {
        ArrayList<E> tulos = occurrences(L,k);
        int i = 0;
        int j = 0;
        while (i < tulos.size()){
            while(j < L.size()) {
                if (tulos.get(i) == L.get(j)) {
                    L.remove(j);
                    j++;
                }
            }
            i++;
        }
    }
    public static <E> ArrayList<E> occurrences(ArrayList<E> L, int k) {
        ArrayList<E> result = new ArrayList<>();
        Map<E, Integer> mm = new HashMap<>();

        Iterator<E> iterator = L.iterator();
        while (iterator.hasNext()){
            E x = iterator.next();
            if(mm.containsKey(x)){
                mm.put(x, mm.get(x)+1);
            }
            else {
                mm.put(x, 1);
            }
        }
        for (Map.Entry<E, Integer> i : mm.entrySet()){
            E x = i.getKey();
            int arvo = i.getValue();
            if(arvo == k) {
                result.add(x);
            }
        }
        return result;
    }
}
