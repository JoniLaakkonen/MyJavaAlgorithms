import fi.uef.cs.tra.BTree;//own libary of university of eastern finland for learning purposes
import fi.uef.cs.tra.BTreeNode;//own libary of university of eastern finland for learning purposes


public class inorderChild {

    /**
     * Palauttaa binÃ¤Ã¤ripuun sisÃ¤jÃ¤rjestyksessÃ¤ ensimmÃ¤isen solmun.
     *
     * @param T Tarkasteltava puu.
     * @return SisÃ¤jÃ¤rjestyksessÃ¤ ensimmÃ¤inen solmu tai null jos puu on tyhjÃ¤.
     */
    public static <E> BTreeNode<E> inorderFirst(BTree<E> T) {

        BTreeNode<E> n = T.getRoot();
        if (n == null)
            return null;
        // Ã¤Ã¤rimmÃ¤isenÃ¤ vasemmalla oleva solmu
        while (n.getLeftChild() != null)
            n = n.getLeftChild();
        return n;
    }

    /**
     * returns in order chid node
     *
     * @param n   BinÃ¤Ã¤ripuun solmu.
     * @param <E> solmun alkioiden tyyppi
     * @return seuraajasolmu sisÃ¤jÃ¤rjestyksessÃ¤ tai null jollei seuraajaa ole.
     */
    public static <E> BTreeNode<E> inorderNext(BTreeNode<E> n) {

        //TODO
        BTreeNode<E> right;
        BTreeNode<E> gparent;
        // jos solmulla on oikea lapsi, haetaan sen
        // vasemmanpuoleinen jalkelainen
        if (n.getRightChild() != null){
            right = n.getRightChild();
            if (right.getLeftChild() != null)
                n = right.getLeftChild();
            return n;
        }
        // muutoin haetaan ensimmainen esivanhempi jonka
        // vasemmassa alipuussa solmu n on
        if (n.getParent() != null){
            n = n.getParent();
        }
        if (n.getParent() != null){
            gparent = n.getParent();
            if (gparent.getLeftChild() != null)
                n = gparent.getLeftChild();
            return n;
        }
        // jollei loytynyt
        return null;
    }
} // class TRAI_22_t17.java