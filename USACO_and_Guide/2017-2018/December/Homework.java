// 2017 Dec Silver P1

import java.util.*;
import java.io.*;

public class Homework {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // mfw file I/O
        BufferedReader br = new BufferedReader(new FileReader("homework.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("homework.out")));
        
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) a[i] = Integer.parseInt(st.nextToken());
        
        long[] suf = new long[n+1], min = new long[n+1];
        suf[n] = min[n] = (long) a[n];
        //ew suffixes 
        for (int i = n-1; i > 0; i--) {
            suf[i] = 0L + suf[i+1] + a[i];
            min[i] = Math.min(min[i+1], 0L + a[i]);
        }
        
        long sum = suf[2] - min[2], cnt = n - 2; //ok just figure out what the best possible avg is using these two things
        for (int i = 1; i <= n-2; i++) {
            //'i' being the number removed
            //that means we have n - i - 1 left I think
            //and then the sum is suf[i+1] - min[i+1]
            //we need to find some way to compare sum / cnt with (suf[i+1] - min[i+1]) / (n - i - 1) without floats being goose
            //multiply by both denominators and you get sum * (n - i - 1) vs (suf[i+1] - min[i+1]) * cnt
            //then it's just better if the one with the cnt is more than the one with the sum lmao ok this is easy
            
            if (1L * (suf[i+1] - min[i+1]) * cnt > 1L * sum * (n - i - 1)) {
                sum = suf[i+1] - min[i+1];
                cnt = n - i - 1;
            }
        }
        
        // ok now thats done, print all the actual K's that work
        for (int i = 1; i <= n-2; i++) {
            if (1L * (suf[i+1] - min[i+1]) * cnt == 1L * sum * (n - i - 1)) out.println(i);
        }
        br.close(); out.close();
    }
}