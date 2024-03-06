import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2Shovels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long shovels = scanner.nextLong();

        long sum = 2 * shovels - 1;
        long cur = String.valueOf(sum).length() - 1;
        if (sum == 1) {

        }
        if (sum == Long.parseLong("9".repeat(String.valueOf(shovels).length()))) {
            System.out.println("1");
        } else if (sum < 9) {
            System.out.println(shovels * (shovels - 1) / 2);
        } else {
            List<Long> nines = new ArrayList<>();
            long flag = 0;
            String aboba = "";
            for (int j = 0; j < cur; j++) {
                aboba += "9";
            }
            for (long i = 0; i < 9; i++) {   
                long boba = Long.parseLong(String.valueOf(i) + aboba);
                nines.add(boba);
            }
            for (int j = 0; j < nines.size(); j++) {
                if (nines.get(j) <= shovels + 1) {
                    flag += nines.get(j) / 2;
                } else if (nines.get(j) > 2 * shovels - 1) {
                    continue;
                } else {
                    flag += (shovels - (nines.get(j) - shovels) + 1) / 2;
                }
            }
            System.out.println(flag);
        }
    }
}
