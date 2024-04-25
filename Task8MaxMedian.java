import java.util.Scanner;
 
public class Task8MaxMedian {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), k = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int l = 1, r = n + 1;
        while (l + 1 < r) {
            int m = (l + r + 1) / 2;
            int[] f = new int[n];
            for (int i = 0; i < n; i++) {
                f[i] = a[i] >= m ? 1 : -1;
                f[i] += i > 0 ? f[i - 1] : 0;
            }
            int dif = f[k - 1], minf = 0;
            for (int i = k; i < n; i++) {
                minf = Math.min(minf, f[i - k]);
                dif = Math.max(dif, f[i] - minf);
            }
            if (dif > 0) { l = m; } else { r = m; }
        }
        System.out.println(l);
    }
}