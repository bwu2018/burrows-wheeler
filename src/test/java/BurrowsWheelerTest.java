import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Test;

public class BurrowsWheelerTest {

    private static String DECODED_INPUT = "ABRACADABRA!";
    private static String DECODED_INPUT2 = "couscous";
    private static String DECODED_INPUT3 = "zebra";

    private static byte[] ENCODED_INPUT = { 0x0, 0x0, 0x0, 0x3, 0x41, 0x52, 0x44, 0x21, 0x52, 0x43,
            0x41, 0x41, 0x41, 0x41, 0x42, 0x42 };
    private static byte[] ENCODED_INPUT2 = { 0x00, 0x00, 0x00, 0x00, 0x73, 0x73, 0x63, 0x63, 0x75,
            0x75, 0x6f, 0x6f };
    private static byte[] ENCODED_INPUT3 = { 0x00, 0x00, 0x00, 0x04, 0x72, 0x65, 0x7a, 0x62, 0x61 };

    @Test
    public void testTransform() {
        // backup standard in and out
        InputStream standardIn = System.in;
        PrintStream standardOut = System.out;
        try {
            // setup new input
            System.setIn(new ByteArrayInputStream(DECODED_INPUT.getBytes()));
            // create new output stream as byte array and assign to standard
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            System.setOut(new PrintStream(baos));

            BurrowsWheeler.transform();
            byte[] encoded = baos.toByteArray();
            assertEquals(ENCODED_INPUT.length, encoded.length);
            for (int i = 0; i < encoded.length; i++) {
                assertEquals(ENCODED_INPUT[i], encoded[i]);
            }
        } finally {
            // return standard input and output
            System.setIn(standardIn);
            System.setOut(standardOut);
        }
    }
    
    @Test
    public void testTransform2() {
        // backup standard in and out
        InputStream standardIn = System.in;
        PrintStream standardOut = System.out;
        try {
            // setup new input
            System.setIn(new ByteArrayInputStream(DECODED_INPUT2.getBytes()));
            // create new output stream as byte array and assign to standard
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            System.setOut(new PrintStream(baos));

            BurrowsWheeler.transform();
            byte[] encoded = baos.toByteArray();
            assertEquals(ENCODED_INPUT2.length, encoded.length);
            for (int i = 0; i < encoded.length; i++) {
                assertEquals(ENCODED_INPUT2[i], encoded[i]);
            }
        } finally {
            // return standard input and output
            System.setIn(standardIn);
            System.setOut(standardOut);
        }
    }
    
    @Test
    public void testTransform3() {
        // backup standard in and out
        InputStream standardIn = System.in;
        PrintStream standardOut = System.out;
        try {
            // setup new input
            System.setIn(new ByteArrayInputStream(DECODED_INPUT3.getBytes()));
            // create new output stream as byte array and assign to standard
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            System.setOut(new PrintStream(baos));

            BurrowsWheeler.transform();
            byte[] encoded = baos.toByteArray();
            assertEquals(ENCODED_INPUT3.length, encoded.length);
            for (int i = 0; i < encoded.length; i++) {
                assertEquals(ENCODED_INPUT3[i], encoded[i]);
            }
        } finally {
            // return standard input and output
            System.setIn(standardIn);
            System.setOut(standardOut);
        }
    }

    @Test
    public void testInverseTransform() {
        // backup standard in and out
        InputStream standardIn = System.in;
        PrintStream standardOut = System.out;
        try {
            // setup new input with encoded message
            System.setIn(new ByteArrayInputStream(ENCODED_INPUT));
            // create new output stream as byte array and assign to standard
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            System.setOut(new PrintStream(baos));

            BurrowsWheeler.inverseTransform();
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
    public void testInverseTransform2() {
        // backup standard in and out
        InputStream standardIn = System.in;
        PrintStream standardOut = System.out;
        try {
            // setup new input with encoded message
            System.setIn(new ByteArrayInputStream(ENCODED_INPUT2));
            // create new output stream as byte array and assign to standard
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            System.setOut(new PrintStream(baos));

            BurrowsWheeler.inverseTransform();
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
    public void testInverseTransform3() {
        // backup standard in and out
        InputStream standardIn = System.in;
        PrintStream standardOut = System.out;
        try {
            // setup new input with encoded message
            System.setIn(new ByteArrayInputStream(ENCODED_INPUT3));
            // create new output stream as byte array and assign to standard
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            System.setOut(new PrintStream(baos));

            BurrowsWheeler.inverseTransform();
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
