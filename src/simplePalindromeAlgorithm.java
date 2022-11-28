

import java.util.*;

public class simplePalindromeAlgorithm {

    /**
     * From sting to a Deque.
     *
     * @param S syÃ¶temerkkijono
     * @return merkit pakkana
     */
    public static Deque<Character> merkkijonostaPakka(String S) {
        Deque<Character> D = new ArrayDeque<>();

        for (int i = 0; i < S.length(); i++)
            D.addLast(S.charAt(i));

        return D;

    } // merkkijonostaPakka()


    public static Deque cloneDeque(Deque D) {
        Deque<Character> D1 = new ArrayDeque<>();

        Iterator<Character> di = D.descendingIterator();

        while (di.hasNext()){
            Character x = di.next();
            D1.push(x);
        }
        return D1;
    }
    /**
     * Palindrome? Algorithm will find out
     *
     * @param S syÃ¶temerkkijono
     * @return totuusarvo
     */
    public static boolean isItPalindrome (String S) {
        Deque<Character> D = merkkijonostaPakka(S);
        // TODO
        Deque<Character> copyD = cloneDeque(D);
        Deque<Character> D1 = new ArrayDeque<>();

        boolean onko = false;
        while(!copyD.isEmpty()){
            D1.push(copyD.pop());
        }
        if (Arrays.equals(D.toArray(), D1.toArray())){
            onko = true;
        }
        return onko;
    } // onkoPalindromi()
} // class
