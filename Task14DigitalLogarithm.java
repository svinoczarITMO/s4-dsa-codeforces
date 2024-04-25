import java.util.*;

public class Task14DigitalLogarithm {

    public static int f(int x) {
        return (int) (Math.log10(x) + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            PriorityQueue<Integer> a = new PriorityQueue<>((o1, o2) -> o2 - o1);
            PriorityQueue<Integer> b = new PriorityQueue<>((o1, o2) -> o2 - o1);

            for (int i = 0; i < n; i++)
                a.add(scanner.nextInt());
            for (int i = 0; i < n; i++)
                b.add(scanner.nextInt());
            int cnt = 0;
            while (a.size() > 0) {
                int x = a.peek();
                int y = b.peek();
                if (x < y) {
                    b.poll();
                    b.add(f(y));
                    cnt++;
                } else if (x > y) {
                    a.poll();
                    a.add(f(x));
                    cnt++;
                } else {
                    a.poll();
                    b.poll();
                }
            }
            System.out.println(cnt);
        }
    }
}