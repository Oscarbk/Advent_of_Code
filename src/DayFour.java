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
            String mas = "MAS";
            String sam = "SAM";
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
                    if ((row+2 < maxRow) && (col+2 < maxCol)) {
                        String cross1 = "" + puzzle.get(row).get(col) +
                                             puzzle.get(row+1).get(col+1) +
                                             puzzle.get(row+2).get(col+2);

                        String cross2 = "" + puzzle.get(row).get(col+2) +
                                             puzzle.get(row+1).get(col+1) +
                                             puzzle.get(row+2).get(col);

                        if ((cross1.equals(sam) || cross1.equals(mas)) && (cross2.equals(sam) || cross2.equals(mas))) {
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
