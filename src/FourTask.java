import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FourTask {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            HashMap<String, List<Integer>> arguments = new HashMap<>();
            List<String> argumentsRollback = new ArrayList<>();
            boolean rollback = false;
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                if (line.contains("=")) {
                    String[] values = line.split("=");
                    int assignValue;
                    String key = values[0];
                    String value = values[1];
                    try {
                        assignValue = Integer.parseInt(value);
                    } catch (Exception e) {
                        try {
                            List<Integer> suitableVal = arguments.get(value);
                            assignValue = suitableVal.get(suitableVal.size() - 1);
                        } catch (Exception exc) {
                            assignValue = 0;
                        }
                        System.out.println(assignValue);
                    }
                    if (rollback) argumentsRollback.add(values[0]);
                    if (arguments.containsKey(key)) {
                        arguments.get(key).add(assignValue);
                    } else arguments.put(values[0], new ArrayList<>(List.of(assignValue)));
                } else if (line.contains("{")) rollback = true;
                else if (line.contains("}")) {
                    for (String s : argumentsRollback) {
                        List<Integer> appropriateList = arguments.get(s);
                        int size = appropriateList.size();
                        appropriateList.remove(size - 1);
                    }
                    rollback = false;
                    argumentsRollback.clear();
                } else break;
            }
        }
    }
}
