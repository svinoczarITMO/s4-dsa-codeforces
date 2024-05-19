import java.io.*;
public class task17Lakes{
	static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	static boolean[][] vis;
	static int[][] arr;
    public static void main(String[] args)throws IOException{
    	int t = Integer.parseInt(sc.readLine());
    	while(t-->0) {
    		String[] line = sc.readLine().split(" ");
    		int n = Integer.parseInt(line[0]);
    		int m = Integer.parseInt(line[1]);
    		arr = new int[n][m];
    		vis = new boolean[n][m];
    		for(int i = 0;i<n;i++) {
    			String[] line1 = sc.readLine().split(" ");
    			for(int j = 0;j<m;j++) {
    				arr[i][j] = Integer.parseInt(line1[j]); 
    				vis[i][j]= false; 
    			}
    		}
    		int ans = 0;
    		for(int i = 0;i<n;i++) {
    			for(int j = 0;j<m;j++) {
    				if(!vis[i][j] && arr[i][j] != 0) {
    					ans = Math.max(ans, dfs(i,j));
    				}
    			}
    		}
    		System.out.println(ans);
    	}
    }
    static int dfs(int i,int j) {
    	vis[i][j] = true; 
    	int ans = arr[i][j];
    	if(i != 0 && arr[i-1][j] != 0 && vis[i-1][j] != true ) {
    		ans += dfs(i-1, j);
    	}
    	if(i != arr.length-1 && arr[i+1][j] != 0 && vis[i+1][j] != true ) {
    		ans += dfs(i+1, j);
    	}
    	if(j != 0 && arr[i][j-1] != 0 && vis[i][j-1] != true ) {
    		ans += dfs(i, j-1);
    	}
    	if(j != arr[0].length-1 && arr[i][j+1] != 0 && vis[i][j+1] != true ) {
    		ans += dfs(i, j+1);
    	}
    	return ans;
    }
}