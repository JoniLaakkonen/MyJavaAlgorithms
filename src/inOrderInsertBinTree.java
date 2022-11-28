
/**
 * This algorithm adds elements to binary tree
 **/



import fi.uef.cs.tra.BTree;//own libary of university of eastern finland for learning purposes
import fi.uef.cs.tra.BTreeNode;//own libary of university of eastern finland for learning purposes

public class inOrderInsertBinTree {

    /**
     * 15. inorder insert to bin tree
     * @param T binÃ¤Ã¤ripuu
     * @param x lisÃ¤ttÃ¤vÃ¤ alkio
     * @return tehtiinkÃ¶ lisÃ¤ys vai ei
     */
    public static <E extends Comparable<? super E>>
    boolean inorderInsert(BTree<E> T, E x) {

        // if empty, element becomes the root node
        // else finds node that would parent that element
        // node and make insertion (if there is no such element already)

        BTreeNode<E> n = T.getRoot();
        BTreeNode<E> parent = null;
        boolean added = false;

        if (T.getRoot() == null)
            T.setRoot(new BTreeNode<E>(x));
        else {
            while (n != null) {
                if (x.compareTo(n.getElement()) == 0) {
                    return true;
                } else if (x.compareTo(n.getElement()) < 0) {
                    parent = n;
                    n = n.getLeftChild();
                } else {
                    parent = n;
                    n = n.getRightChild();
                }
            }

            if(parent != null){
                if(x.compareTo(parent.getElement()) < 0){
                    parent.setLeftChild(new BTreeNode<E>(x));
                    added = true;
                }
                else{
                    parent.setRightChild(new BTreeNode<E>(x));
                    added = true;
                }
            }
        }



        return added;

    } // inorderInsert()

    /**
     * checks if node is now inorder member
     * @param T sisÃ¤jÃ¤rjestetty binÃ¤Ã¤ripuu
     * @param x etsittÃ¤vÃ¤ alkio
     * @param <E> alkiotyyppi
     * @return true jos alkio x on puussa, muuten false
     */
    public static <E extends Comparable<? super E>>
    boolean inorderMember(BTree<E> T, E x) {
        BTreeNode<E> n = T.getRoot();

        while (n != null) {
            if (x.compareTo(n.getElement()) == 0)
                return true;
            else if (x.compareTo(n.getElement()) < 0)
                n = n.getLeftChild();
            else
                n = n.getRightChild();
        } // while
        return false;

    } // inorderMember()


} // class TRAI_22_t15.java