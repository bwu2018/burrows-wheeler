import java.util.Arrays;
import java.util.Comparator;

/**
 * A fundamental data structure, which describes the abstraction
 * of a sorted array of the n circular suffixes of a string of length n.
 *
 * @author bwu2018
 *
 */
public class CircularSuffixArray {

    /**
     * Length of string.
     */
    private int length;

    /**
     * Input string.
     */
    private String string;

    /**
     * Array of indexes.
     */
    private Integer[] index;

    /**
     * Creates a circular suffix array of s.
     *
     * @param s
     *            a string
     */
    public CircularSuffixArray(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        length = s.length();
        // double up for easier traversal
        this.string = s + s;
        index = new Integer[length()];

        // initialize array
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }

        Arrays.sort(index, alphabeticalOrder());
    }

    /**
     * Returns a comparator.
     *
     * @return a comparator
     */
    private Comparator<Integer> alphabeticalOrder() {
        return new OrderAlphabetical();
    }

    /**
     * Comparator that orders according to alphabetical order.
     *
     * @author bwu2018
     *
     */
    private class OrderAlphabetical implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            int num1 = o1;
            int num2 = o2;
            for (int i = 0; i < length(); i++) {
                if (string.charAt(num1) < string.charAt(num2)) {
                    return -1;
                } else if (string.charAt(num1) > string.charAt(num2)) {
                    return 1;
                }
                num1++;
                num2++;
            }
            return 0;
        }
    }

    /**
     * Returns length of given string.
     *
     * @return length of string
     */
    public int length() {
        return length;
    }

    /**
     * Returns index of ith sorted suffix.
     *
     * @param i
     *            given index
     * @return index of ith sorted suffix
     */
    public int index(int i) {
        if (i < 0 || i >= length()) {
            throw new IllegalArgumentException();
        }
        return index[i];
    }

    /**
     * Unit testing.
     *
     * @param args
     *            command line arguments
     */
    // unit testing (required)
    public static void main(String[] args) {

    }
}
