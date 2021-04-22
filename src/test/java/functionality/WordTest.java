package functionality;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordTest {

    @Test
    public void compareToTest1() {
        Word word = new Word("a");

        assertEquals("different a",word.compareTo(new Word("a")),0);
    }
    @Test
    public void compareToTest2() {
        Word word = new Word("a");

        assertEquals("",word.compareTo(new Word("b")),-1);
    }
    @Test
    public void compareToTest3() {
        Word word = new Word("a");

        assertTrue("",word.compareTo(new Word("б"))<0);
    }
    @Test
    public void compareToTest4() {
        Word word = new Word("m");

        assertTrue("",word.compareTo(new Word("a"))>0);
    }

    @Test
    public void equalsTest1() {
        assertEquals(new Word("m"),new Word("m"));
    }
    @Test
    public void equalsTest2() {
        assertNotEquals(new Word("m"),new Word("f"));
    }
}