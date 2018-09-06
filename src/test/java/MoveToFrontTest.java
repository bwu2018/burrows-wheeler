import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Test;

/**
 * 
 */

/**
 * @author jddevaughnbrown
 *
 */
public class MoveToFrontTest {

    private static String DECODED_INPUT = "ABRACADABRA!";
    private static String DECODED_INPUT2 = "BANANA!";
    private static String DECODED_INPUT3 = "AHHHHHHH!";

    private static byte[] ENCODED_INPUT = { 0x41, 0x42, 0x52, 0x2, 0x44, 0x1, 0x45, 0x1, 0x4, 0x4,
            0x2, 0x26 };
    private static byte[] ENCODED_INPUT2 = { 0x42, 0x42, 0x4e, 0x01, 0x01, 0x01, 0x24 };
    private static byte[] ENCODED_INPUT3 = { 0x41, 0x48, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x23 };

    @Test
    public void testEncode() {
        // backup standard in and out
        InputStream standardIn = System.in;
        PrintStream standardOut = System.out;
        try {
            // setup new input
            System.setIn(new ByteArrayInputStream(DECODED_INPUT.getBytes()));
            // create new output stream as byte array and assign to standard
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            System.setOut(new PrintStream(baos));

            MoveToFront.encode();
            byte[] encoded = baos.toByteArray();
            assertEquals(ENCODED_INPUT.length, encoded.length);
            // first
            assertEquals(ENCODED_INPUT[0], encoded[0]);
            assertEquals(ENCODED_INPUT[1], encoded[1]);
            assertEquals(ENCODED_INPUT[2], encoded[2]);
            assertEquals(ENCODED_INPUT[3], encoded[3]);
            // letters
            assertEquals(ENCODED_INPUT[4], encoded[4]);
            assertEquals(ENCODED_INPUT[5], encoded[5]);
            assertEquals(ENCODED_INPUT[6], encoded[6]);
            assertEquals(ENCODED_INPUT[7], encoded[7]);
            assertEquals(ENCODED_INPUT[8], encoded[8]);
            assertEquals(ENCODED_INPUT[9], encoded[9]);
            assertEquals(ENCODED_INPUT[10], encoded[10]);
            assertEquals(ENCODED_INPUT[11], encoded[11]);
        } finally {
            // return standard input and output
            System.setIn(standardIn);
            System.setOut(standardOut);
        }
    }

    @Test
    public void testEncode2() {
        // backup standard in and out
        InputStream standardIn = System.in;
        PrintStream standardOut = System.out;
        try {
            // setup new input
            System.setIn(new ByteArrayInputStream(DECODED_INPUT2.getBytes()));
            // create new output stream as byte array and assign to standard
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            System.setOut(new PrintStream(baos));

            MoveToFront.encode();
            byte[] encoded = baos.toByteArray();

            assertEquals(ENCODED_INPUT2.length, encoded.length);
            // first
            assertEquals(ENCODED_INPUT2[0], encoded[0]);
            assertEquals(ENCODED_INPUT2[1], encoded[1]);
            assertEquals(ENCODED_INPUT2[2], encoded[2]);
            assertEquals(ENCODED_INPUT2[3], encoded[3]);
            // letters
            assertEquals(ENCODED_INPUT2[4], encoded[4]);
            assertEquals(ENCODED_INPUT2[5], encoded[5]);
            assertEquals(ENCODED_INPUT2[6], encoded[6]);
        } finally {
            // return standard input and output
            System.setIn(standardIn);
            System.setOut(standardOut);
        }
    }

    @Test
    public void testEncode3() {
        // backup standard in and out
        InputStream standardIn = System.in;
        PrintStream standardOut = System.out;
        try {
            // setup new input
            System.setIn(new ByteArrayInputStream(DECODED_INPUT3.getBytes()));
            // create new output stream as byte array and assign to standard
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            System.setOut(new PrintStream(baos));

            MoveToFront.encode();
            byte[] encoded = baos.toByteArray();
            assertEquals(ENCODED_INPUT3.length, encoded.length);
            // first
            assertEquals(ENCODED_INPUT3[0], encoded[0]);
            assertEquals(ENCODED_INPUT3[1], encoded[1]);
            assertEquals(ENCODED_INPUT3[2], encoded[2]);
            assertEquals(ENCODED_INPUT3[3], encoded[3]);
            // letters
            assertEquals(ENCODED_INPUT3[4], encoded[4]);
            assertEquals(ENCODED_INPUT3[5], encoded[5]);
            assertEquals(ENCODED_INPUT3[6], encoded[6]);
            assertEquals(ENCODED_INPUT3[7], encoded[7]);
            assertEquals(ENCODED_INPUT3[8], encoded[8]);
        } finally {
            // return standard input and output
            System.setIn(standardIn);
            System.setOut(standardOut);
        }
    }

    @Test
    public void testDecode() {
        // backup standard in and out
        InputStream standardIn = System.in;
        PrintStream standardOut = System.out;
        try {
            // setup new input with encoded message
            System.setIn(new ByteArrayInputStream(ENCODED_INPUT));
            // create new output stream as byte array and assign to standard
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            System.setOut(new PrintStream(baos));

            MoveToFront.decode();
            String decoded = baos.toString();
            // check length and chars
            assertEquals(DECODED_INPUT.length(), decoded.length());
            assertEquals(DECODED_INPUT, decoded);
        } finally {
            // return standard input and output
            System.setIn(standardIn);
            System.setOut(standardOut);
        }
    }
    
    @Test
    public void testDecode2() {
        // backup standard in and out
        InputStream standardIn = System.in;
        PrintStream standardOut = System.out;
        try {
            // setup new input with encoded message
            System.setIn(new ByteArrayInputStream(ENCODED_INPUT2));
            // create new output stream as byte array and assign to standard
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            System.setOut(new PrintStream(baos));

            MoveToFront.decode();
            String decoded = baos.toString();
            // check length and chars
            assertEquals(DECODED_INPUT2.length(), decoded.length());
            assertEquals(DECODED_INPUT2, decoded);
        } finally {
            // return standard input and output
            System.setIn(standardIn);
            System.setOut(standardOut);
        }
    }
    
    @Test
    public void testDecode3() {
        // backup standard in and out
        InputStream standardIn = System.in;
        PrintStream standardOut = System.out;
        try {
            // setup new input with encoded message
            System.setIn(new ByteArrayInputStream(ENCODED_INPUT3));
            // create new output stream as byte array and assign to standard
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            System.setOut(new PrintStream(baos));

            MoveToFront.decode();
            String decoded = baos.toString();
            // check length and chars
            assertEquals(DECODED_INPUT3.length(), decoded.length());
            assertEquals(DECODED_INPUT3, decoded);
        } finally {
            // return standard input and output
            System.setIn(standardIn);
            System.setOut(standardOut);
        }
    }

}
