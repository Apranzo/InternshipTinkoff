import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FiveTask {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            List<String> fileCabinet = new ArrayList<>();
            List<String> fileCabinetSort;
            int n = scan.nextInt(), q = scan.nextInt(), k;
            String[] request;
            String valueOnIndex = "", statement;
            boolean findFlag;
            int count;
            scan.nextLine();
            while (n > 0) {
                fileCabinet.add(scan.nextLine());
                --n;
            }
            fileCabinetSort = new ArrayList<>(fileCabinet);
            fileCabinetSort.sort(String::compareTo);
            while (q > 0) {
                findFlag = false;
                request = scan.nextLine().split(" ");
                k = Integer.parseInt(request[0]);
                statement = request[1];
                count = 0;
                for (String s : fileCabinetSort) {
                    valueOnIndex = s;
                    if (valueOnIndex.startsWith(statement)) {
                        ++count;
                        if (count == k) break;

                    }
                }
                if (fileCabinet.contains(valueOnIndex)) {
                    findFlag = true;
                    System.out.println(fileCabinet.indexOf(valueOnIndex) + 1);
                }
                if (!findFlag) System.out.println("-1");
                --q;
            }
        }
    }
}
