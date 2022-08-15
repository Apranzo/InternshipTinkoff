import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SixTask {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            List<Elevator> elevators = new ArrayList<>();
            int maxChain = 0, n, minFloor = 1000000000, nowFloor = 0, maxFloor = 0, elevIndex = 0;
            n = scan.nextInt();
            while (n > 0) {
                int start = scan.nextInt(), end = scan.nextInt();
                minFloor = Math.min(minFloor, start);
                maxFloor = Math.max(maxFloor, end);
                elevators.add(new Elevator(start, end));
                n--;
            }
            elevators.sort((o1, o2) -> {
                if (o1.getStartFloor() > o2.getStartFloor()) return 1;
                else if (o1.getStartFloor() < o2.getStartFloor()) return -1;
                else {
                    return Integer.compare(o1.getEndFloor(), o2.getEndFloor());
                }
            });
            while (nowFloor != maxFloor) {
                nowFloor = minFloor;
                for (int i = 0; i < elevators.size(); ++i) {
                    Elevator e = elevators.get(i);
                    if (nowFloor == e.getStartFloor()) {
                        nowFloor = e.getEndFloor();
                        elevIndex = i;
                        maxChain++;
                    }
                }
                if (nowFloor != maxFloor) {
                    elevators.remove(elevIndex);
                    maxChain = 0;
                }
            }
            System.out.println(maxChain);
        }

    }


}
class Elevator {
    private final int startFloor;
    private final int endFloor;

    public Elevator(int startFloor, int endFloor) {
        this.startFloor = startFloor;
        this.endFloor = endFloor;
    }

    public int getStartFloor() {
        return startFloor;
    }

    public int getEndFloor() {
        return endFloor;
    }
}
