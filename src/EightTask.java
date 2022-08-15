import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EightTask {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int n = scan.nextInt(), m = scan.nextInt();
            scan.nextLine();
            List<String> domains = getData(scan, n);
            List<Integer> answers = checkRequests(scan, m, domains);
            answers.forEach(System.out::println);


        }
    }

    private static List<Integer> checkRequests(Scanner scan, int m, List<String> domains) {
        List<Integer> answers = new ArrayList<>();
        while (m > 0) {
            int countSuitableDomain = 0;
            String[] clientsRequest = scan.nextLine().split(" ");
            String R = clientsRequest[0], Q = clientsRequest[1];
            for (String s : domains) if (s.startsWith(R) && s.endsWith(Q)) countSuitableDomain++;
            answers.add(countSuitableDomain);
            --m;
        }
        return answers;
    }

    private static List<String> getData(Scanner scan, int n) {
        List<String> data = new ArrayList<>();
        while (n > 0) {
            data.add(scan.nextLine());
            --n;
        }
        return data;
    }

}
