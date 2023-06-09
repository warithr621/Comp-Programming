// HSCTF9 algorithms/hacking (MAJOR CREDIT TO ANTHONY)

import java.util.*;
import java.io.*;

public class Floyd {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("files.txt"));
        PrintWriter pw = new PrintWriter(System.out);
        String chicken = "";
        String s;
        while ((s = br.readLine()) != null) {
            String[] ss = s.split(", ");
            int n = ss.length;
            int[] a = new int[1000005];
            ArrayList<Integer>[] adj = new ArrayList[1000005];
            for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                a[i] = Integer.parseInt(ss[i-1]);
                adj[i].add(a[i]); adj[a[i]].add(i);
            }
            boolean[] vis = new boolean[1000005];
            ArrayList<Integer> starts = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (vis[i]) continue;
                starts.add(i);
                Queue<Integer> q = new LinkedList<>();
                q.add(i); vis[i] = true;
                while (!q.isEmpty()) {
                    int p = q.remove();
                    for (int j : adj[p]) {
                        if (vis[j]) continue;
                        q.add(j); vis[j] = true;
                    }
                }
            }
            int ans = 0;
            for (int i : starts) {
                int x = i, y = i;
                do {
                    x = a[x];
                    y = a[a[y]];
                } while (x != y);
                do {
                    y = a[y];
                    ans++;
                } while (x != y);
            }
            chicken += ans + ", ";
        }
        pw.println(chicken);
        pw.flush();
        pw.close();
    }
}
