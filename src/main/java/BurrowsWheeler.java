
import java.util.Arrays;
import java.util.HashMap;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.Queue;

/**
 * Burrows–Wheeler data compression algorithm. This revolutionary algorithm outcompresses gzip and
 * PKZIP, is relatively easy to implement, and is not protected by any patents. It forms the basis
 * of the Unix compression utility bzip2.
 *
 * @author bwu2018
 *
 */
public class BurrowsWheeler {

    /**
     * Utility classes should not have a public constructor.
     */
    private BurrowsWheeler() {
    }

    /**
     * Applies Burrows-Wheeler transform, reading from standard input and writing to standard
     * output.
     */
    public static void transform() {
        String string = BinaryStdIn.readString();
        CircularSuffixArray csa = new CircularSuffixArray(string);
        int first = 0;
        while (csa.index(first) != 0 && first < csa.length()) {
            first++;
        }
        BinaryStdOut.write(first);
        for (int i = 0; i < csa.length(); i++) {
            BinaryStdOut
                    .write(string.charAt((csa.index(i) + string.length() - 1) % string.length()));
        }
        BinaryStdOut.close();
    }

    /**
     * Apply Burrows-Wheeler inverse transform, reading from standard input and writing to standard
     * output.
     */
    public static void inverseTransform() {
        int first = BinaryStdIn.readInt();
        String t = BinaryStdIn.readString();
        char[] chars = t.toCharArray();

        // create a map of Character to a Queue
        HashMap<Character, Queue<Integer>> map = new HashMap<Character, Queue<Integer>>();

        // go through t, consider each character in t as a key, put positions of t's in the Queue
        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], new Queue<Integer>());
            }
            map.get(chars[i]).enqueue(i);
        }

        // get first chars array by sorting t
        Arrays.sort(chars);

        // build next
        int[] next = new int[t.length()];
        for (int i = 0; i < t.length(); i++) {
            next[i] = map.get(chars[i]).dequeue();
        }

        // print out everything
        int currentRow = first;
        for (int i = 0; i < t.length(); i++) {
            BinaryStdOut.write(chars[currentRow]);
            currentRow = next[currentRow];
        }
        BinaryStdOut.close();
    }

    /**
     * if args[0] is '-', apply Burrows-Wheeler transform.
     * if args[0] is '+', apply Burrows-Wheeler inverse transform.
     * @param args
     *      command line arguments
     */
    public static void main(String[] args) {
        if (args[0].equals("-")) {
            transform();
        } else if (args[0].equals("+")) {
            inverseTransform();
        }
    }

}
