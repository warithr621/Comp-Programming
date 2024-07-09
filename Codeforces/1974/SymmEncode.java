// https://codeforces.com/contest/1974/problem/B

import java.util.*;

public class SymmEncode {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T --> 0) {
            int N = sc.nextInt();
            String S = sc.next();
            TreeSet<Character> ts = new TreeSet<>();
            for (char c : S.toCharArray()) ts.add(c);
            ArrayList<Character> mirror = new ArrayList<>(ts);
            
            char[] conv = new char[26];
            for (int i = 0; i < mirror.size(); i++) {
                conv[mirror.get(i) - 'a'] = mirror.get(mirror.size() - i - 1);
            }
            
            StringBuilder ans = new StringBuilder();
            for (char c : S.toCharArray()) ans.append(conv[c - 'a']);
            System.out.println(ans.toString());
        }
    }
}