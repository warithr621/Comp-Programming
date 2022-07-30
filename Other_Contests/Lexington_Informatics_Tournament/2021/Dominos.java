//Source: 2021 Lexington Informatics Tournament Standard Round A (Dominos)

import java.io.*;
import java.util.*;

public class Dominos {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    // 	T = Integer.parseInt(next());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(next()), m = Integer.parseInt(next()), k = Integer.parseInt(next());
            ArrayList<Integer> al = new ArrayList<Integer>();
            int track = 0;
            for (int i = 0; i < n; i++) {
                track = 0;
                for (int j = 0; j < m; j++) {
                    if (Integer.parseInt(next()) == 1) ++track;
                    else {
                        al.add(track);
                        track = 0;
                    }
                }
                al.add(track);
            }
            Collections.sort(al, Collections.reverseOrder());
            int ans = 0;
            for (int i = 0; i < k; i++) ans += al.get(i);
            out.println(ans);
        }
        br.close(); out.close();
    }
    static String next() throws IOException{
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
}
