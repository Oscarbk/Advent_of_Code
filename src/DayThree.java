import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayThree {
    public static void solution() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/resources/dayThree.txt"))) {
            String line;
            String regex = "mul\\((\\d{1,3}),(\\d{1,3})\\)";
            int sum = 0;
            while ((line = br.readLine()) != null) {
                // Process the line here
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(line);

                while (matcher.find()) {
                    String[] parts = matcher.group().split(",");
                    sum += Integer.parseInt(parts[0].substring(4)) * Integer.parseInt(parts[1].substring(0, parts[1].length()-1));
                }
            }
            System.out.println(sum);
            } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
