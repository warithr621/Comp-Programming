// https://codeforces.com/problemset/problem/1638/B

import java.util.*;
public class OddSwapSort {
    static Scanner sc = new Scanner(System.in);
    
    public static boolean sorted(ArrayList<Integer> a) {
        for (int i = 0; i < a.size()-1; i++) {
            if (a.get(i) > a.get(i+1)) return false;
        }
        return true;
    }
    
    public static void solve() {
        int N = sc.nextInt();
        ArrayList<Integer> E = new ArrayList<>(), O = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int X = sc.nextInt();
            if (X % 2 == 0) E.add(X);
            else O.add(X);
        }
        
        System.out.println(sorted(E) && sorted(O) ? "Yes" : "nO");
    }
    
    public static void main(String[] args) {
        int T = sc.nextInt();
        while(T-->0) solve();
    }
}