import java.util.*;
import java.io.*;

public class Puzzle {
    private final int columns;
    private final int rows;

    final String ANSI_RED = "\u001B[31m";
    final String ANSI_RESET = "\u001B[0m";

    String fileName = "src/resources/wordlist.txt";

    HashMap<Integer, String> letters = new HashMap<>();
    StringBuilder str = new StringBuilder();
    Set<String> set = new HashSet<>();
    Set<String> foundWords = new HashSet<>();


    public Puzzle(int columns, int rows) {
        this.columns = columns;
        this.rows = rows;
        loadFile(fileName);
    }

    public void checkWords(String rowStr) {
        for (String word : set) {
            if (rowStr.contains(word)) {
                System.out.println("Word " + word + " found");
                foundWords.add(word);
            }
        }
    }

    public void printPuzzle() {
        Random r = new Random();

        // Print top border
        for (int i = 0; i < (columns * 2) + 7; i++) {
            System.out.print("-");
        }
        System.out.println();

        // Generate the puzzle and store the rows in the HashMap
        for (int i = 0; i < rows; i++) {
            str.setLength(0);

            for (int j = 0; j < columns; j++) {
                char c = (char) (r.nextInt(26) + 'a');
                str.append(c).append(" ");
            }

            letters.put(i, str.toString());
        }

        // Check each row for found words
        for (int i = 0; i < letters.size(); i++) {
            String rowStr = letters.get(i);
            checkWords(rowStr.replace(" ", "")); // fixes spacing
        }

        // Print the puzzle with highlighted found words
        for (int i = 0; i < letters.size(); i++) {
            System.out.print("||  ");
            String rowStr = letters.get(i);

            for (String word : foundWords) {
                String spacedWord = String.join(" ", word.split(""));
                if (rowStr.contains(spacedWord)) {
                    rowStr = rowStr.replace(spacedWord, ANSI_RED + spacedWord + ANSI_RESET);
                }
            }
            System.out.print(rowStr + " ||");
            System.out.println();
        }

        // Print bottom border
        for (int i = 0; i < (columns * 2) + 7; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void loadFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                String word = reader.nextLine();
                set.add(word);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }
}
