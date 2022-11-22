//Problem: https://codeforces.com/contest/1536/problem/B

import java.io.*;
import java.util.*;

public class verurteilung {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st = new StringTokenizer("");
    static int T = 1;
    public static void main(String args[]) throws IOException{
    	T = Integer.parseInt(next());
    	ArrayList<String> al = new ArrayList<String>();
    	for (int i = 0; i < 26; i++) al.add(Character.toString(i + 97));
    	for (int i = 0; i < 26; i++) for (int j = 0; j < 26; j++) al.add(al.get(i) + "" + al.get(j));
    	for (int i = 0; i < 26; i++) for (int j = 0; j < 26; j++) for (int k = 0; k < 26; k++) al.add(al.get(i) + "" + al.get(j) + "" + al.get(k));
        for (int t = 1; t <= T; t++) {
            next();
            String s = next();
            for (String str : al) {
                if (!s.contains(str)) {out.println(str); break;}
            }
        }
        br.close(); out.close();
    }
    static String next() throws IOException{
        while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
}
