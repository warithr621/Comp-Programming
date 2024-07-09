// https://leetcode.com/problems/unique-number-of-occurrences/description/

import java.util.*;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int x : arr) {
            hm.put(x, hm.getOrDefault(x, 0) + 1);
        }
        HashSet<Integer> hs = new HashSet<>();
        for (int x : hm.keySet()) {
            if (hs.contains(hm.get(x))) return false;
            hs.add(hm.get(x));
        }
        return true;
    }
}