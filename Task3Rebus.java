import java.util.*;

public class Task3Rebus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().replace(" ", "");
        long n = Long.parseLong(str.split("=")[1]);
        long plus = str.chars().filter(c -> c == '+').count() + 1;
        long minus = str.chars().filter(c -> c == '-').count();
        long min = plus - n * minus;
        long max = plus * n - minus;

        if (n < min || n > max) {
            System.out.println("Impossible");
            return;
        }
        System.out.println("Possible");
        StringBuilder ans = new StringBuilder();
        long curr = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '?') {
                if (i > 0 && str.charAt(i - 1) == '-') {
                    if (minus == 1 && plus == 0) {
                        ans.append("- ").append(curr - n).append(" ");
                        break;
                    }
                    minus--;
                    for (long x = 1; x <= n; x++) {
                        if (curr - x + plus - n * minus <= n && n <= curr - x + n * plus - minus) {
                            curr -= x;
                            ans.append("- ").append(x).append(" ");
                            break;
                        }
                    }
                } else {
                    if (plus == 1 && minus == 0) {
                        ans.append("+ ").append(n - curr).append(" ");
                        break;
                    }
                    plus--;
                    for (long x = 1; x <= n; x++) {
                        if (curr + x + plus - n * minus <= n && n <= curr + x + n * plus - minus) {
                            curr += x;
                            ans.append("+ ").append(x).append(" ");
                            break;
                        }
                    }
                }
            }
        }
        ans.append("= ").append(n);
        System.out.println(ans.toString().substring(2));
    }
}