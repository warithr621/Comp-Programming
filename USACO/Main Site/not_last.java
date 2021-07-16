//Problem: 2017 January Bronze P1 --> http://www.usaco.org/index.php?page=viewproblem2&cpid=687

import java.io.*;
import java.util.*;

public class not_last {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader("notlast.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("notlast.out")));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(br.readLine());
        String[] cows = {"Bessie", "Elsie", "Daisy", "Gertie", "Annabelle", "Maggie", "Henrietta"};
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        while(n-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken(); int milk = Integer.parseInt(st.nextToken());
            a[find(cows, s)] += milk;
        }   
        int min = Integer.MAX_VALUE;
        for (int i : a) min = Math.min(i, min);
        int sec = Integer.MAX_VALUE;
        for (int i : a) if (i < sec && i > min) sec = i;
        int count = 0, keep = 0;
        for (int i = 0; i < 7; i++) {
            if (a[i] == sec) {++count; keep = i;}
        }
        out.println(count == 1 ? cows[keep] : "Tie");
        br.close(); out.close();
    }
    static int find(String[] a, String x) {
        for (int i = 0; i < a.length; i++) if (x.equals(a[i])) return i;
        return -1;
    }
}
