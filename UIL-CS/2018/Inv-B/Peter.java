//Problem 12

import java.io.*;
import java.util.*;

public class Peter {
    static int T = 1;
    public static void main(String args[]) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("peter.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // T = Integer.parseInt(br.readLine());
        for (int ttt = 1; ttt <= T; ttt++) {
            String s;
            while((s = br.readLine()) != null) {
                int total = Integer.parseInt(s);
                out.print(total);
                String[] temp = br.readLine().split(" ");
                int[] coins = new int[temp.length];
                for(int i = 0; i < temp.length; i++) coins[i] = Integer.parseInt(temp[i]);
                ArrayList<Integer> al = new ArrayList<Integer>();
                int cur = coins.length-1;
                while(total != 0) {
                    for (int i = 0; i < total / coins[cur]; i++) al.add(coins[cur]);
                    total -= total / coins[cur] * coins[cur];
                    --cur;
                }
                Collections.sort(al);
                out.printf(" %d ", al.size());
                for (int i : al) out.print(i + " ");
                out.println();
            }
        }
        br.close(); out.close();
    }
}