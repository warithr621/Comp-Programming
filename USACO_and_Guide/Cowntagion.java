// 2020 Dec Silver P1

import java.util.*;
import java.io.*;

public class Cowntagion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // mfw file I/O
        // BufferedReader br = new BufferedReader(new FileReader("cowntagion.in"));
        // PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowntagion.out")));
        
        int n = Integer.parseInt(br.readLine());
        int[] con = new int[n+1]; //store the number of connected nodes
        StringTokenizer st; //bro I hate Java 😭
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            ++con[a]; ++con[b];
        }
        
        int ans = n-1; //to account for all the travelling to other barns
        for (int i = 1; i <= n; i++) {
            if (con[i] > 1 || i == 1) { //if it you know is not a leaf (or the first thing)
                ans += log2(con[i] + (i == 1 ? 1 : 0)); //to generate 2^n infected cows, you need n days (round up cause yeah)
                //wait also might have to subtract 1 cause smth smth the first one is quirky
            }
        }
        out.println(ans);
        br.close(); out.close();
    }
    static int log2(int x) {
        double d = Math.log(x) / Math.log(2); //hey lets try this lol
        return (int) Math.ceil(d);
    }
}