public class Main {
    public static void main(String[] args) {
        int columns = 25, rows = 10;

        // Print the puzzle
        Puzzle puzzle = new Puzzle(columns, rows);
        puzzle.printPuzzle();

        puzzle.checkWords();
    }
}
