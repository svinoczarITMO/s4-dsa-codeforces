import java.util.*;
public class Task11Registration {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        HashMap<String, Integer>m = new HashMap<>();
        while(t-->0) {
           String s=sc.next();
           if(!m.containsKey(s)) {
               System.out.println("OK");
               m.put(s,1);
           }
           else {
               int count=m.get(s);
               System.out.println(s+count);
               m.put(s,count+1);
           }
       }
    }
}