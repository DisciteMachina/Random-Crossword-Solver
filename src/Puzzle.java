import java.util.Random;
import java.util.HashMap;

public class Puzzle {
    private final int columns;
    private final int rows;

    HashMap<Integer, String> letters = new HashMap<>();
    StringBuilder str = new StringBuilder();

    public Puzzle(int columns, int rows) {
        this.columns = columns;
        this.rows = rows;
    }

    public void printPuzzle() {
        Random r = new Random();

        for (int i = 0; i < (columns * 2)+ 7; i++) {
            System.out.print("-");
        }
        System.out.println();

        for (int i = 0; i < rows; i++) {
            System.out.print("||  ");

            str.setLength(0);

            for (int j = 0; j < columns; j++) {
                char c = (char)(r.nextInt(26) + 'a');
                System.out.print(c + " ");
                str.append(c);
                letters.put(i, str.toString());
            }

            System.out.print(" ||");
            System.out.println();
        }
        for (int i = 0; i < (columns * 2)+ 7; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void checkWords() {
        for (int i = 0; i < letters.size(); i++) {
            System.out.println("Row " + (i+1) + " " + letters.get(i));
        }
    }
}
