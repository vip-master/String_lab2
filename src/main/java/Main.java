import functionality.Reading;
import functionality.Word;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("target\\classes\\text.txt");
            try {
                List<Word> dictionary = Reading.readFile(fileReader);
                Collections.sort(dictionary);
                char c = '@';
                for (Word word : dictionary) {
                    if (!word.toString().equals("")) {
                        char here = word.toString().charAt(0);
                        if (here != c) System.out.println(word.toString());
                        else System.out.println(word.toString());
                        c = here;
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            } finally {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(2);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(3);
        }


    }
}
