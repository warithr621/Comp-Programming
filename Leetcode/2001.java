// https://leetcode.com/problems/number-of-pairs-of-interchangeable-rectangles/description/

import java.util.*;

class Solution {

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<String, Integer> hm = new HashMap<>();
        for (int[] arr : rectangles) {
            int a = arr[0], b = arr[1];
            int g = gcd(a, b);
            String str = (a/g) + "/" + (b/g);
            hm.put(str, hm.getOrDefault(str, 0) + 1);
        }
        long ans = 0;
        for (String s : hm.keySet()) {
            long x = hm.get(s);
            ans += x * (x-1) / 2;
        }
        return ans;
    }
}