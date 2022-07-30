// https://open.kattis.com/problems/birthday

import java.util.*;

public class Birthday {
    static Scanner sc = new Scanner(System.in);
    static boolean[][] adj; //adjacency matrix
    static boolean[] vis; //vis array
    
    public static void main(String[] args) {
        while(sc.hasNextInt()) solve();
    }
    
    static void dfs(int x) {
        vis[x] = true;
        for (int j = 0; j < adj[x].length; j++) {
            if (adj[x][j] && !vis[j]) dfs(j);
        }
    }
    
    static void solve() {
        int p = sc.nextInt(), c = sc.nextInt();
        if (p == 0 && c == 0) {
            //the ending statement
            return;
        }
        
        adj = new boolean[p][p];
        for (int i = 0; i < c; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            adj[x][y] = adj[y][x] = true;
        }
        
        boolean possible = true;
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < p; j++) {
                if (!adj[i][j]) {
                    continue;
                    //we don't care if we can't even use the edge
                }
                
                //step 1: remove the edge
                adj[i][j] = false;
                //step 2: run the dfs
                vis = new boolean[p];
                dfs(0);
                
                //step 3: check if every node got visited
                boolean message = true;
                for (boolean b : vis) message &= b;
                
                //step 4: update 'works' accordingly
                possible &= message;
                //step 5: readd the edge
                adj[i][j] = true;
            }
        }
        
        System.out.println(possible ? "No" : "Yes");
        /* we print "No" if 'possible' is true because that means it isn't impossible
        ah yes, double negatives */
    }
}
