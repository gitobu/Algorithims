package com.me.prep;

public class MergeSort {

    @SuppressWarnings("rawtypes")
	private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid + 1, hi);
        //copy for [] a to [] aux
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        // the merging process
        // i is the first index of the first half of the array
        // j is the first index of the second half of the array
        int i = lo, j = mid + 1;

        // for every value of k - the indices of [] a
        for (int k = lo; k <= hi; k++) {
            /*Left half exhausted take from the right*/
            if (i > mid)
                a[k] = aux[j++];
                /*Right half exhausted take from the left*/
            else if (j > hi)
                a[k] = aux[i++];
                /*Current key on the right less than current key on the left take from the right*/
            else if (less(aux[j], aux[i]))
                a[k] = aux[j++];
                /*Current key on the right greater than current key on the left take from the left */
            else
                a[k] = aux[i++];
        }
        assert isSorted(a, lo, hi);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            //System.out.print(a[i]);
            System.out.println(a[i]);
        }
    }

    public static void main(String args[]) {
        // Comparable[] a = {"E", "E", "G", "M", "R", "A", "C", "E", "R", "T"};

        Comparable[] aa = {"A", "X", "G", "M", "R"};
        Comparable[] bb = {"H", "D", "J", "Y", "Z"};
        /*Merge the two comparable arrays*/
        Comparable[] a = new Comparable[aa.length + bb.length];
        System.arraycopy(aa, 0, a, 0, aa.length);
        System.arraycopy(bb, 0, a, aa.length, bb.length);

        MergeSort.sort(a);
        show(a);
    }
}



