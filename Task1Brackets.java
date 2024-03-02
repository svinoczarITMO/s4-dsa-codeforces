import java.util.Scanner;

public class Task1Brackets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testsCount = in.nextInt();
        for (int i = 0; i < testsCount; i++) {
            int bracketsCount = in.nextInt();
            String brackets = in.next();
            System.out.println(bracketsMovement(bracketsCount, brackets.split("")));
        }
        in.close();
    }

    private static int bracketsMovement (int count, String[] brackets) {
        int open = 0;
        int close = 0;
        int n = 0;
        for (int i = 0; i < count; i++) {
            int s = 0;
            if (brackets[i].equals("(")) {
                open++;
            } else if (brackets[i].equals(")")) {
                close++;
            }
            s = open - close;
            if (s < 0) {
                n += 1;
                close--;
            }
        }
        return n;
    }
}
