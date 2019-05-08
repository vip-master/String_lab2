package functionality;

import org.junit.Test;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ReadingTest {

    @Test
    public void readFileTest() throws IOException {
        FileReader reader = new FileReader("test.txt");
        List<Word> absent = Reading.readFile(reader);
        List<Word> expected = new ArrayList<Word>();

        expected.add(new Word("anihilator"));
        expected.add(new Word("banana"));
        expected.add(new Word("chiscake"));
        expected.add(new Word("мета"));

        assertEquals("Incorrect splitting",expected,absent);
    }
}