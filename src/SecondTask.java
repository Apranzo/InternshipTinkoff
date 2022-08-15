import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SecondTask {
    public static void main(String[] args) {
        int N;
        Map<String, Integer> countWin = new HashMap<>();
        try (Scanner scan = new Scanner(System.in)) {
            N = scan.nextInt();
            scan.nextLine();
            int i = 0;
            while (i < N) {
                String team = toNormalState(scan.nextLine());
                if (!countWin.containsKey(team)) countWin.put(team, 1);
                else {
                    countWin.replace(team, countWin.get(team) + 1);
                }
                i++;
            }
            System.out.println(countWin.values().stream().max(Integer::compareTo).get());
        }
    }

    private static String toNormalState(String s) {
        return Arrays.toString(Arrays.stream(s.split(" ")).sorted(String::compareTo).toArray());
    }
}
