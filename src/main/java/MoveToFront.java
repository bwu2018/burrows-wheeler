import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

/**
 * Maintain an ordered sequence of the characters in the alphabet, and repeatedly read a character
 * from the input message, print out the position in which that character appears, and move that
 * character to the front of the sequence.
 *
 * @author bwu2018
 *
 */
public class MoveToFront {

    /**
     * Utility classes should have private constructors.
     */
    private MoveToFront() {
    }

    /**
     * Apply move-to-front encoding, reading from standard input and writing to standard output.
     */
    public static void encode() {
        List<Character> aNSIList = createANSIList();
        // while loop that goes through input and grab char (reset char position in ANSIList each
        // time)
        while (!BinaryStdIn.isEmpty()) {
            int count = 0;
            char currentChar = BinaryStdIn.readChar();
            Iterator<Character> iterator = aNSIList.iterator();
            while (iterator.hasNext()) {
                // check if thing in iterator is equal to char you pulled earlier
                if (iterator.next().equals(Character.valueOf(currentChar))) {
                    BinaryStdOut.write(count, 8);
                    char tempChar = aNSIList.get(count);
                    aNSIList.remove(count);
                    aNSIList.add(0, tempChar);
                    break;
                }
                count++;
            }
        }
        BinaryStdOut.close();
    }

    /**
     * Creates a list size of 256.
     *
     * @return a list size of 256.
     */
    private static List<Character> createANSIList() {
        int ALPHABET_SIZE = 256;
        List<Character> ansiList = new LinkedList<Character>();
        for (int alphabetPosition = 0; alphabetPosition < ALPHABET_SIZE; alphabetPosition++) {
            ansiList.add((char) alphabetPosition);
        }
        return ansiList;
    }

    /**
     * Apply move-to-front decoding, reading from standard input and writing to standard output.
     */
    public static void decode() {
        List<Character> aNSIList = createANSIList();
        while (!BinaryStdIn.isEmpty()) {
            int position = BinaryStdIn.readChar();
            BinaryStdOut.write(aNSIList.get(position), 8);
            char tempChar = aNSIList.get(position);
            aNSIList.remove(position);
            aNSIList.add(0, tempChar);
        }
        BinaryStdOut.close();
    }

    /**
     * if args[0] is '-', apply move-to-front encoding. if args[0] is '+', apply move-to-front
     * decoding.
     *
     * @param args
     *            command line arguments
     */
    // if args[0] is '-', apply move-to-front encoding
    // if args[0] is '+', apply move-to-front decoding
    public static void main(String[] args) {
        if (args[0].equals("-")) {
            encode();
        } else if (args[0].equals("+")) {
            decode();
        }
    }
}
