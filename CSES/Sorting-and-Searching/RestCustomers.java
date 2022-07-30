//CSES Restaurant Customers

import java.util.*;
import java.io.*;

public class RestCustomers {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        int n = Integer.parseInt(br.readLine());
        ArrayList<Pair> al = new ArrayList<Pair>();
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            al.add(new Pair(a, 1));
            al.add(new Pair(b, -1));
        }
        
        Collections.sort(al);
        int sum = 0;
        int ans = -1;
        for (Pair p : al) {
            sum += p.second;
            ans = Math.max(ans, sum);
        }
        out.println(ans);
        
        br.close(); out.close();
    }
    
}

class Pair implements Comparable<Pair> { //pair moment
    int first, second;
    Pair(int x, int y) {
        this.first = x;
        this.second = y;
    }
    public String toString() {
        return first + " " + second;
    }
    public int compareTo(Pair p) {
        if (this.first > p.first) return 1;
        if (this.first < p.first) return -1;
        if (this.second > p.second) return 1;
        return -1;
    }
}
