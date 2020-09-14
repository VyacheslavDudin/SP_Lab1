package com.company;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        final List<Character> vowels = Arrays.asList('A', 'E', 'I', 'O', 'U');

        try {
            File file = new File("example1.txt");
            Scanner fileReader = new Scanner(file);
            HashSet result = new HashSet();
            int maxWordLength = 30;
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] words = line.split("[^a-zA-Zа-яА-Я0-9]+");
                for (String word: words ) {
                    boolean containsConsonant = false;
                    if (word.length() > maxWordLength) {
                        word = word.substring(0, maxWordLength);
                    }
                    for (char letter: word.toCharArray()) {
                        if (!vowels.contains(Character.toUpperCase(letter))) {
                            containsConsonant = true;
                        }
                    }
                    if (!containsConsonant) {
                        result.add(word);
                    }
                }
            }
            System.out.println("Words that consists of vowels only:");
            System.out.println(result);
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }

    }
}
