import java.io.*;
import java.util.*;
public class task19YaroslavAndTime {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int array[] = new int[n + 1];
        int dist[][] = new int[n + 1][n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 2; i < n; i++)
            array[i] = Integer.parseInt(st.nextToken());
        int x[] = new int[n + 1];
        int y[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++) {
                if(i == j)continue;
                int distance = Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]);
                dist[i][j] = distance * d - array[i];
             //   System.out.println(i + " " + j + " " + dist[i][j]);
            }
        for (int k = 1; k <= n; k++)
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++)
                    if (dist[i][j] > dist[i][k] + dist[k][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
        System.out.print(dist[1][n]);
    }
}