import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DayFour {
    public static void solution() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/resources/dayFour.txt"))) {
            ArrayList<ArrayList<Character>> puzzle= new ArrayList<>();
            int character;
            int row = 0;
            int col;
            int sum = 0;
            String xmas = "XMAS";
            puzzle.add(new ArrayList<>());
            while ((character = br.read()) != -1) {
                // Process the line here
                if (character == '\n') {
                    puzzle.add(new ArrayList<>());
                    row++;
                }
                else {
                    puzzle.get(row).add((char) character);
                }
            }
            int maxCol = puzzle.size();
            int maxRow = puzzle.get(0).size();
            for (row = 0; row < puzzle.get(0).size(); row++) {
                for (col = 0; col < puzzle.size(); col++) {
                    //System.out.print(puzzle.get(row).get(col) + " ");
                    // Look right
                    if ((col+3 < maxCol)) {
                        String check = "" + puzzle.get(row).get(col) +
                                            puzzle.get(row).get(col+1) +
                                            puzzle.get(row).get(col+2) +
                                            puzzle.get(row).get(col+3);
                        if (check.equals(xmas)) {
                            sum++;
                        }
                    }
                    // Look left
                    if ((col-3 >= 0)) {
                        String check = "" + puzzle.get(row).get(col) +
                                            puzzle.get(row).get(col-1) +
                                            puzzle.get(row).get(col-2) +
                                            puzzle.get(row).get(col-3);
                        if (check.equals(xmas)) {
                            sum++;
                        }
                    }
                    // Look up
                    if ((row-3 >= 0)) {
                        String check = "" + puzzle.get(row).get(col) +
                                            puzzle.get(row-1).get(col) +
                                            puzzle.get(row-2).get(col) +
                                            puzzle.get(row-3).get(col);
                        if (check.equals(xmas)) {
                            sum++;
                        }
                    }
                    // Look down
                    if (row+3 < maxRow) {
                        String check = "" + puzzle.get(row).get(col) +
                                            puzzle.get(row+1).get(col) +
                                            puzzle.get(row+2).get(col) +
                                            puzzle.get(row+3).get(col);
                        if (check.equals(xmas)) {
                            sum++;
                        }
                    }
                    // Look diagonally up-left
                    if ((row-3 >= 0) && (col-3 >=0)) {
                        String check = "" + puzzle.get(row).get(col) +
                                            puzzle.get(row-1).get(col-1) +
                                            puzzle.get(row-2).get(col-2) +
                                            puzzle.get(row-3).get(col-3);
                        if (check.equals(xmas)) {
                            sum++;
                        }
                    }
                    // Look diagonally up-right
                    if ((col+3 < maxCol) && (row-3 >= 0)) {
                        String check = "" + puzzle.get(row).get(col) +
                                            puzzle.get(row-1).get(col+1) +
                                            puzzle.get(row-2).get(col+2) +
                                            puzzle.get(row-3).get(col+3);
                        if (check.equals(xmas)) {
                            sum++;
                        }
                    }
                    // Look diagonally down-left
                    if ((row+3 < maxRow) && (col-3 >= 0)) {
                        String check = "" + puzzle.get(row).get(col) +
                                            puzzle.get(row+1).get(col-1) +
                                            puzzle.get(row+2).get(col-2) +
                                            puzzle.get(row+3).get(col-3);
                        if (check.equals(xmas)) {
                            sum++;
                        }
                    }
                    //Look diagonally down-right
                    if ((row+3 < maxRow) && (col+3 < maxCol)) {
                        String check = "" + puzzle.get(row).get(col) +
                                            puzzle.get(row+1).get(col+1) +
                                            puzzle.get(row+2).get(col+2) +
                                            puzzle.get(row+3).get(col+3);
                        if (check.equals(xmas)) {
                            sum++;
                        }
                    }
                }
            }
            System.out.println(sum);
         } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
