/*************************************************************************
 *  Test method for CircularSuffixArray class. More details 
 *    http://coursera.cs.princeton.edu/algs4/assignments/burrows.html
 *  
 *  Links:
 *  Specification: http://coursera.cs.princeton.edu/algs4/assignments/burrows.html
 *                 http://coursera.cs.princeton.edu/algs4/checklists/burrows.html
 *             
 *  Execution: Run as JUnit test
 *                    
 *  Execution only with installed algs4.jar, stdlib.jar and JUnit4 library
 *  
 *************************************************************************/
import static org.junit.Assert.*;

import org.junit.Test;


public class CircularSuffixArrayTest {

   @Test(expected = java.lang.IllegalArgumentException.class)
   public void testExceptionIsThrown() {
      new CircularSuffixArray("");
      new CircularSuffixArray(null);
    }
   
   @Test
   public void testCircularSuffixArray() {
      new CircularSuffixArray("String");
   }

   @Test
   public void testLength() {
      CircularSuffixArray csa = new CircularSuffixArray("ABRACADABRA!");
      assertEquals("ABRACADABRA!'s length is 12", 12, csa.length());
   }

   @Test
   public void testIndex() {
      CircularSuffixArray csa = new CircularSuffixArray("ABRACADABRA!");
      assertEquals("0 - 11", 11, csa.index(0));
      assertEquals("1 - 10", 10, csa.index(1));
      assertEquals("2 - 7", 7, csa.index(2));
      assertEquals("3 - 0", 0, csa.index(3));
      assertEquals("4 - 3", 3, csa.index(4));
      assertEquals("5 - 5", 5, csa.index(5));
      assertEquals("6 - 8", 8, csa.index(6));
      assertEquals("7 - 1", 1, csa.index(7));
      assertEquals("8 - 4", 4, csa.index(8));
      assertEquals("9 - 6", 6, csa.index(9));
      assertEquals("10 - 9", 9, csa.index(10));
      assertEquals("11 - 2", 2, csa.index(11));
   }

}