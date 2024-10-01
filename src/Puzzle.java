import java.util.Random;

public class Puzzle {
    private final int columns;
    private final int rows;

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

            for (int j = 0; j < columns; j++) {
                System.out.print((char)(r.nextInt(26) + 'a') + " ");
            }

            System.out.print(" ||");
            System.out.println();
        }
        for (int i = 0; i < (columns * 2)+ 7; i++) {
            System.out.print("-");
        }
    }
}
