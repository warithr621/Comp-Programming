// UIL CS 2019 State (P9)

import java.util.*;
import java.io.*;

public class Me {
    
    static Scanner sc;
    static int N;
    
    public static int first(Problem p) {
        return p.name.charAt(0) - 'A';
    }
    
    public static String sub(Problem p, int shift) {
        // shift = 0 --> start with 'A', shift = 1 --> start with 'B', etc.
        return "" + (char) ('A' + shift) + p.name.substring(1);
    }
    
    public static void main(String[] args) throws IOException {
        // sc = new Scanner(System.in);
        sc = new Scanner( new File("me.dat") );
        int T = sc.nextInt();
        
        for (int tt = 1; tt <= T; tt++) {
            N = sc.nextInt();
            Problem[] arr = new Problem[N];
            for (int i = 0; i < N; i++) {
                arr[i] = new Problem(sc.next());
                for (int j = 0; j < 5; j++) arr[i].score += sc.nextInt();
            }
        
            Arrays.sort(arr); // sort from easiest to hardest
            int inf = (int) 1e9;
            int[][] dp = new int[N][26]; // dp[i][j] = cost to sort first 'i' elements, when last element starts with 'j'
            for (int j = 0; j < 26; j++) {
                int diff = j - first(arr[0]);
                dp[0][j] = diff * diff;
            }
            
            for (int i = 1; i < N; i++) {
                for (int j = 0; j < 26; j++) {
                    dp[i][j] = inf;
                    String sec = sub(arr[i], j);
                    int cost = j - first(arr[i]);
                    cost = cost * cost;
                    
                    for (int k = 0; k < 26; k++) {
                        String fst = sub(arr[i-1], k);
                        if (fst.compareTo(sec) < 0) {
                            // comes ahead in order
                            dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + cost);
                        }
                    }
                }
            }
            
            int ans = inf;
            for (int j = 0; j < 26; j++) ans = Math.min(ans, dp[N-1][j]);
            System.out.printf("Case #%d: %d\n", tt, ans == inf ? -1 : ans);
        }
        
        sc.close();
    }
}

class Problem implements Comparable<Problem> {
    String name;
    int score; // since 5 judges for all, we can just compare usm instead of avg
    
    public Problem(String s) {
        this.name = s;
        this.score = 0;
    }
    
    public int compareTo(Problem p) {
        return Integer.compare(score, p.score);
    }
}