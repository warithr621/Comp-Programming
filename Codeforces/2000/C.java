// https://codeforces.com/contest/2000/problem/C

import java.util.*;

public class NumericStrTempl {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T --> 0) {
            int N = sc.nextInt();
            int[] A = new int[N];
            for (int i = 0; i < N; i++) A[i] = sc.nextInt();
            int Q = sc.nextInt();
            while (Q --> 0) {
                String S = sc.next();
                if (S.length() != N) {
                    System.out.println("NO");
                    continue; // why tf is this a case
                }
                boolean works = true;
                boolean[] taken = new boolean[128];
                HashMap<Integer, Character> hm = new HashMap<>();
                for (int i = 0; i < N; i++) {
                    if (!hm.containsKey(A[i])) {
                        // see if char has alr been used
                        if (taken[S.charAt(i)]) {
                            works = false;
                            break;
                        }
                        hm.put(A[i], S.charAt(i));
                        taken[S.charAt(i)] = true;
                    } else {
                        works &= (hm.get(A[i]) == S.charAt(i));
                    }
                }
                HashSet<Integer> used = new HashSet<>();
                HashMap<Character, Integer> hm2 = new HashMap<>();
                for (int i = 0; i < N; i++) {
                    if (!hm2.containsKey(S.charAt(i))) {
                        if (used.contains(A[i])) {
                            works = false;
                            break;
                        }
                        hm2.put(S.charAt(i), A[i]);
                    } else {
                        works &= (hm2.get(S.charAt(i)) == A[i]);
                    }
                }
                System.out.println(works ? "YES" : "NO");
            }
        }
    }
}