import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter amount of columns");
        int columns = input.nextInt();
        System.out.println("Enter amount of rows");
        int rows = input.nextInt();

        Puzzle puzzle = new Puzzle(columns, rows);
        puzzle.printPuzzle();
    }
}
