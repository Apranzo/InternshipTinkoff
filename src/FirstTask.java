import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        List<Integer> coordinateX = new ArrayList<>();
        List<Integer> coordinateY = new ArrayList<>();
        try (Scanner scan = new Scanner(System.in)) {
            getData(coordinateX, coordinateY, scan);
            getData(coordinateX, coordinateY, scan);
            System.out.println(calculation(coordinateX, coordinateY));

        } catch (Exception e) {
            System.out.println("Данные не соответствуют условию: " + e.getMessage());
        }
    }

    private static void checkData(int x1, int y1, int x2, int y2) throws Exception {
        if (x1 < 0 || x1 > x2) throw new Exception("x1 меньше нуля или больше x2");
        else if (x2 > 10) throw new Exception("x2 больше 10");
        else if (y1 < 0 || y1 > y2) throw new Exception("y1 меньше нуля или больше y2");
        else if (y2 > 10) throw new Exception("y2 больше 10");
    }

    private static int calculation(List<Integer> x, List<Integer> y) {
        int maxX = x.stream().max(Integer::compare).get() - x.stream().min(Integer::compare).get();
        int maxY = y.stream().max(Integer::compare).get() - y.stream().min(Integer::compare).get();
        if (maxX > maxY) return maxX * maxX;
        else return maxY * maxY;
    }

    private static void getData(List<Integer> coordinateX, List<Integer> coordinateY, Scanner scan) throws Exception {
        int x1, y1, x2, y2;
        x1 = scan.nextInt();
        y1 = scan.nextInt();
        x2 = scan.nextInt();
        y2 = scan.nextInt();
        checkData(x1, y1, x2, y2);
        coordinateX.add(x1);
        coordinateX.add(x2);
        coordinateY.add(y1);
        coordinateY.add(y2);
    }
}
