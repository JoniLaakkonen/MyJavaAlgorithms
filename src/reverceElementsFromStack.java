import java.util.Stack;

public class reverceElementsFromStack {

    /**
     * Algorithm that reverses k first elements of a stack ex. (a,b,c) -> (c,b,a)
     */
    public static <E> void reverse_k(Stack<E> S, int k) {

        // TODO
        if (S.isEmpty()){
            return;
        }
        Stack<E> S1 = new Stack<>();
        Stack<E> S2 = new Stack<>();
        if (k < S.size()){
            int i = k;
            while (i > 0){
                S1.push(S.pop());
                i--;
            }
            while (k > 0){
                S2.push(S1.pop());
                k--;
            }
        }
        else {
            while (!S.isEmpty()){
                S1.push(S.pop());
            }
            while (!S1.isEmpty()){
                S2.push(S1.pop());
            }
        }
        while (!S2.isEmpty()){
            S.push(S2.pop());
        }
    }
} // class