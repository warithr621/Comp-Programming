// 2020 Dec Silver P2

import java.util.*;
import java.io.*;

public class Pasture {
    
    static int n;
    static ArrayList<Pair> al;
    static long[][] psum;
    
    public static void main(String[] args) throws IOException { //conclusion that "Pair(-1, -1)" was probably stupid
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        n = Integer.parseInt(br.readLine());
        al = new ArrayList<Pair>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            al.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            //input the coords as pairs
        }
        
        Collections.sort(al);
        for (int i = 1; i <= n; i++) {
            int x = i;
            int y = al.get(i-1).second;
            al.set(i-1, new Pair(x, y)); //ok all the x's should be compressed
        }
        Collections.sort(al, new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                if (a.second > b.second) return 1;
                if (a.second < b.second) return -1;
                if (a.first > b.first) return 1;
                return -1; //ok funky custom
            }
        });
        for (int i = 1; i <= n; i++) {
            int x = al.get(i-1).first;
            int y = i;
            al.set(i-1, new Pair(x, y)); //now all the y's are compressed
        }
        // for (int i = 1; i <= n; i++) out.println(al.get(i));
        
        psum = new long[n+1][n+1]; //2-D psums????
        for (int i = 0; i < n; i++) psum[al.get(i).first][al.get(i).second] = 1;
        //bruh where do I go from here
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                //this seems right loll
                //oh wait, 2D psums lol
                psum[i][j] += psum[i-1][j] + psum[i][j-1] - psum[i-1][j-1];
            }
        }
        long ans = 1; //1 because of the null set
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int min_x = Math.min(al.get(i).first, al.get(j).first);
                int max_x = Math.max(al.get(i).first, al.get(j).first);
                //bruh now what
                --min_x; --max_x;
                ans += rect(0, min_x, i, j) * rect(max_x, n-1, i, j);
            }
        }
        out.println(ans);
        // for (int i = 0; i <= n; i++) out.println(Arrays.toString(psum[i]));
        br.close(); out.close();
    }
    
    static long rect(int x1, int x2, int y1, int y2) {
        // return 0L;
        //...ok time to figure out how rect works
        //smth smth weird sum properties
        ++x2; ++y2;
        return psum[x1][y1] + psum[x2][y2] - psum[x1][y2] - psum[x2][y1];
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