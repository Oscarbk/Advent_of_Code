import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class DayTwo {
    public static void solution() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/resources/DayTwo.txt"))) {
            String line;
            int sum = 0;
            while ((line = br.readLine()) != null) {
                int[] parts = Arrays.stream(line.split("\\s")).mapToInt(Integer::parseInt).toArray();
                ArrayList<Integer> list = new ArrayList<>(Arrays.asList(Arrays.stream(parts).boxed().toArray(Integer[]::new)));
                ArrayList<Integer> listCopy;
                if (isSafe(list)) {
                    sum++;
                }
                else {
                    for (int i = 0; i < parts.length; i++) {
                        listCopy = new ArrayList<>(list);
                        listCopy.remove(i);
                        if (isSafe(listCopy)) {
                            sum++;
                            break;
                        }
                    }
                }
            }
            System.out.println(sum);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
    public static boolean isSafe(ArrayList<Integer> parts) {
        boolean ascending = true;
        boolean descending = true;
        boolean isZero = false;
        boolean max = false;
        for (int i = 1; i < parts.size(); i++) {
            int a = parts.get(i);
            int c = parts.get(i-1);

            if (c-a == 0) {
                isZero = true;
            }
            if ((a < c)) {
                ascending = false;
            }
            if (a > c) {
                descending = false;
            }
            if (Math.abs(c-a) > 3) {
                max = true;
            }
        }
        return !isZero && (ascending || descending) && !max;
    }
}
