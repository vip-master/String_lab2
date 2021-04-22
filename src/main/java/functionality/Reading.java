package functionality;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
//import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reading {
    public static List<Word> readFile(FileReader fileStream) throws IOException {
        BufferedReader reader = new BufferedReader(fileStream);
        List<Word> result = new ArrayList<Word>();
        Word word;

        do {
            try {
                word = readWord(reader);
                if(!word.toString().equals(""))result.add(word);
            } catch (IOException e) {
                reader.close();
                throw e;
            }
        } while (!word.toString().equals(""));

        return result;

    }

    private static Word readWord(BufferedReader reader) throws IOException {
        StringBuilder word = new StringBuilder();
        char c;
        do {
            if (!reader.ready()) return new Word("");
            c = (char) reader.read();
        } while (!isLiteral(c));

        boolean isNum = isNormal(c, true);

        do {
            word.append(c);
            c = (char) reader.read();
        } while (reader.ready() && isNormal(c, isNum));
        if (isNormal(c, isNum)) word.append(c);

        return new Word(word.toString());
    }

    private static boolean isNormal(char c, boolean isNum) {
        char[] arr = new char[1];
        arr[0] = c;
        if (Pattern.compile("[0-9]").matcher(String.copyValueOf(arr)).matches()) return isNum;
        if (Pattern.compile("[A-Za-zА-Яа-яЄєЇїІіҐґЁё]").matcher(String.copyValueOf(arr)).matches()) return !isNum;
        return false;

    }

    private static boolean isLiteral(char c) {
        char[] arr = new char[1];
        arr[0] = c;
        return Pattern.compile("[A-Za-zА-Яа-яЄєЇїІіҐґЁё0-9]").matcher(String.copyValueOf(arr)).matches();
    }
}
