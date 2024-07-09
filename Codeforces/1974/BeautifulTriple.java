// https://codeforces.com/contest/1974/problem/C

import java.util.*;
// this MIGHT be overkill

public class BeautifulTriple {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T --> 0) {
            int N = sc.nextInt();
            int[] A = new int[N];
            for (int i = 0; i < N; i++) A[i] = sc.nextInt();
            HashMap<Triple, Integer> freq = new HashMap<>();
            for (int i = 0; i + 2 < N; i++) {
                Triple x = new Triple(A[i], A[i+1], 0);
                Triple y = new Triple(A[i], 0, A[i+2]);
                Triple z = new Triple(0, A[i+1], A[i+2]);
                Triple v = new Triple(A[i], A[i+1], A[i+2]);
                freq.put(x, freq.getOrDefault(x, 0) + 1);
                freq.put(y, freq.getOrDefault(y, 0) + 1);
                freq.put(z, freq.getOrDefault(z, 0) + 1);
                freq.put(v, freq.getOrDefault(v, 0) + 1);
            }
            long ans = 0;
            for (Triple t : freq.keySet()) {
                long v = freq.get(t);
                // System.out.println(t + " " + v);
                ans += (t.zero() ? v * (v-1) / 2 : -3 * v * (v-1) / 2);
            }
            System.out.println(ans);
            // System.out.println("--");
        }
    }
}

class Triple implements Comparable<Triple> {
    int x, y, z;
    Triple(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public boolean zero() {
        return this.x == 0 || this.y == 0 || this.z == 0;
    }
    public int compareTo(Triple t) {
        if (this.x != t.x) return this.x - t.x;
        if (this.y != t.y) return this.y - t.y;
        return this.z - t.z;
    }
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Triple t = (Triple) obj;
        return this.x == t.x && this.y == t.y && this.z == t.z;
    }
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}