import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SevenTask {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            String market = scan.nextLine();
            List<Integer> answer = new ArrayList<>();
            int n = scan.nextInt();
            while (n > 0) {
                int start = scan.nextInt(), end = scan.nextInt(), countSteps = 0;
                char[] subMarket = market.substring(start - 1, end).toCharArray();
                char[] orderPurchase = subMarket.clone();
                Arrays.sort(orderPurchase);
                for (int j = 0, i = 0; ; ++j) {
                    if (j == subMarket.length) j = 0;
                    if (orderPurchase[i] == subMarket[j]) ++i;
                    if (i == orderPurchase.length) break;
                    ++countSteps;
                }
                answer.add(countSteps);
                --n;
            }
            answer.forEach(System.out::println);
        }

    }
}
