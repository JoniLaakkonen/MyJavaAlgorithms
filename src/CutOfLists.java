// TraI_21_t4_5.java SJ
// Esimerkkiratkaisu viikon 1 tehtÃ¤viin 4-5

/**
 * Algorithm that gets two integer lists as parameter (Integer[] A, Integer[] B) and creates
 * and returns new integer list that includes every element that occur in both of those arrays
 * (cut). Each element (.equals() returns true) appears in resulted array only once, even if it
 * appears in both of those arrays multiple times.
 *
 * Second metod does the same thing with arraylists.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CutOfLists {

    // PÃ¤Ã¤ohjelman kÃ¤yttÃ¶:
    // java TRAI_22_t4_5 [N] [N2] [S]
    // missÃ¤ N on alkioiden mÃ¤Ã¤rÃ¤, N2 on alkoiden mÃ¤Ã¤rÃ¤ toisessa taulukossa
    // ja S on satunnaislukusiemen
    public static void main(String[] args) {

        // tsize of lists
        int n1 = 10;
        if (args.length > 0) n1 = Integer.parseInt(args[0]);

        int n2 = n1 + 2;
        if (args.length > 1) n2 = Integer.parseInt(args[1]);

        // random seed
        int siemen = 42;
        if (args.length > 2) siemen = Integer.parseInt(args[2]);

        // example lists
        Integer[] T1 = new Integer[n1];
        Integer[] T2 = new Integer[n2];

        // fill with elements
        java.util.Random r = new java.util.Random(siemen);
        for (int i = 0; i < n1; i++) {
            T1[i] = r.nextInt(n1);
        }

        for (int i = 0; i < n2; i++) {
            T2[i] = r.nextInt(n2 * 2);
        }

        // print lists if there is only few elements
        if (n1 <= 20 && n2 <= 20) {
            System.out.println("T1: " + Arrays.toString(T1));
            System.out.println("T2: " + Arrays.toString(T2));
        }

        // funtion call (cutOfListsAB)
        Integer[] E4 = cutOfListsAB(T1, T2);

        System.out.print("First cutOfListsAB, cut = ");
        if (n1 <= 20 && n2 <= 20) {
            System.out.println(Arrays.toString(E4));
        } else {
            System.out.println(E4.length + " alkioinen taulukko");
            // huom: tÃ¤mÃ¤ tulostaa taulukon koon, ei todellisten alkioiden mÃ¤Ã¤rÃ¤Ã¤!
        }

        // Muodostetaan taulukoista ArrayList:t

        ArrayList<Integer> L1 = new ArrayList<>(T1.length);
        ArrayList<Integer> L2 = new ArrayList<>(T2.length);
        for (Integer x : T1) L1.add(x);

        for (Integer x : T2) L2.add(x);

        // Function call (cutOfArraysAB)
        ArrayList<Integer> E5 = cutOfArraysAB(L1, L2);

        System.out.print("Function cutOfArraysAB, ¨cut = ");
        if (n1 <= 20 && n2 <= 20) {
            System.out.println(E5);
        } else {
            System.out.println(E5.size() + " alkiota");
        }
    } // main()


    /**
     *
     * @param T1 first list
     * @param T2 nd list
     * @return return as cut list
     */
    public static Integer[] cutOfListsAB(Integer[] T1, Integer[] T2) {

        Integer[] tulos = null;

        // TODO
        int i = 0;
        int j = 0;
        int k = 0;
        Integer [] apuT = new Integer[T1.length+T2.length];
        while (i<T1.length){
            apuT[k] = T1[i];
            i++;
            k++;
        }
        while (j<T2.length){
            apuT[k] = T2[j];
            j++;
            k++;
        }
        Arrays.sort(apuT);

        tulos = new Integer[apuT.length];
        j = 0;

        //go trough list
        for (i = 0; i < apuT.length - 1; i++) {

            //if index is not same as follower
            if (!apuT[i].equals(apuT[i + 1])) {
                tulos[j++] = apuT[i];
            }
        }
        tulos[j++] = apuT[apuT.length - 1];

        return tulos;
    }


    /**
     * this version is O(n^2) time complexity, a little faster
     *
     *
     * @param L1 first list
     * @param L2 nd list
     * @return return as cut array
     */
    public static ArrayList<Integer> cutOfArraysAB(ArrayList<Integer> L1, ArrayList<Integer> L2) {

        ArrayList<Integer> result = new ArrayList<>();

        // TODO
        ArrayList<Integer> apu1 = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < L1.size()) {
            apu1.add(L1.get(i));
            i++;
        }
        while (j < L2.size()) {
            apu1.add(L2.get(j));
            j++;
        }

        Collections.sort(apu1);

        for (Integer element : apu1){
            if (!result.contains(element)){
                result.add(element);
            }
        }

        return result;
    }


} // class