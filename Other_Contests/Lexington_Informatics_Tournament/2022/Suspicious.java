//Source: 2022 Lexington Informatics Tournament Standard Round A (Suspicious Imposters)

import java.util.*;

public class Suspicious {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        Arrays.sort(a, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                String first = Integer.toString(a), second = Integer.toString(b);
                int sumA = 0, sumB = 0;
                for (int i = 0; i < first.length(); i++) sumA += first.charAt(i) - '0';
                for (int i = 0; i < second.length(); i++) sumB += second.charAt(i) - '0';
                sumA %= 13; sumB %= 13;
                if (sumA != sumB) return sumA - sumB;
                return a - b;
            }
        });
        for (int i = n-1; i >= n-m; i--) {
            System.out.println(a[i]);
        }
    }
}