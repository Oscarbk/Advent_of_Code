import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;

public class DayOne {
    public static void solution() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/resources/dayOne.txt"))) {
            String line;
            int sum = 0;
            LinkedList<Integer> list1 = new LinkedList<>();
            LinkedList<Integer> list2 = new LinkedList<>();
            while ((line = br.readLine()) != null) {
                // Process the line here
                String[] parts = line.split("\\s+");

                if (parts.length >= 2) {
                    list1.add(Integer.parseInt(parts[0]));
                    list2.add(Integer.parseInt(parts[1]));
                }
            }
            list1.sort(null);
            list2.sort(null);

            int count;
            for (Integer value : list1) {
                count = 0;
                for (Integer integer : list2) {
                    if (Objects.equals(value, integer)) {
                        count++;
                    }
                }
                sum = sum + (value * count);
            }
            System.out.println(sum);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
