// 2016 Open Silver P3

import java.util.*;
import java.io.*;

public class ClosingFarm {
    
    static boolean[] vis, close;
    static int nodes;
    static ArrayList<ArrayList<Integer>> adj;
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("closing.in"));
        PrintWriter out = new PrintWriter("closing.out");
        
        int N = sc.nextInt(), M = sc.nextInt();
        vis = new boolean[N]; close = new boolean[N];
        adj = new ArrayList<>();
        for (int i = 0; i < N; i++) adj.add(new ArrayList<Integer>());
        
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt() - 1, v = sc.nextInt() - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int ord[] = new int[N];
        for (int i = 0; i< N; i++) ord[i] = sc.nextInt()-1;
        
        for (int i = 0; i < N; i++) {
            Arrays.fill(vis, false);
            nodes = 0;
            dfs(ord[N-1]);
            if (nodes == N-i) out.println("YES");
            else out.println("NO");
            
            close[ord[i]] = true;
        }
        
        out.close();
    }
    
    
    static void dfs(int n) {
        if (vis[n] || close[n]) return;
        ++nodes;
        vis[n] = true;
        for (int x : adj.get(n)) dfs(x);
        
    }
}