import fi.uef.cs.tra.BTreeNode;

import java.util.HashSet;
import java.util.Set;

public class treeToSet {
    public static <E> Set<E> jarjestyksessa(BTreeNode<E> node, Set<E> s) {
        if (node == null) {
            return s;
        }
        jarjestyksessa(node.getLeftChild(), s);
        s.add(node.getElement());
        jarjestyksessa(node.getRightChild(),s);

        return s;
    }
}
