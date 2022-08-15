import java.util.Scanner;

public class ThirdTask {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int n = scan.nextInt();
            if (n == 1) System.out.println(scan.nextInt());
            else {
                int income = 0, loss = 0, profit;
                int i = 0, value, minSubDay = 100000, secondMinSubDay = 99999, maxUnsubDay = 0, secondMaxUnsubDay = 0;
                while (i < n) {
                    value = scan.nextInt();
                    if (i % 2 == 0) {
                        income += value;
                        minSubDay = Math.min(minSubDay, value);
                        secondMinSubDay = Math.max(Math.min(secondMinSubDay, value), minSubDay);
                    } else {
                        loss += value;
                        maxUnsubDay = Math.max(maxUnsubDay, value);
                        secondMaxUnsubDay = Math.min(Math.max(secondMaxUnsubDay, value), maxUnsubDay);
                    }
                    i++;
                }
                profit = income + maxUnsubDay + secondMaxUnsubDay - minSubDay - secondMinSubDay - loss;
                System.out.println(profit);
            }
        }
    }
}
