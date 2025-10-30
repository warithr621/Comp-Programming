// https://leetcode.com/problems/find-original-array-from-doubled-array/

class Solution {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 == 1) {
            return new int[0];
        }
        int n = changed.length / 2;
        int[] ans = new int[n];
        Arrays.sort(changed);
        int ptr = 0;
        Map<Integer, Integer> looking = new HashMap<>();
        for (int x : changed) {
            if (x % 2 == 0 && looking.getOrDefault(x/2, 0) > 0) {
                if (ptr == n) return new int[0];
                // System.out.println("!" + x);
                looking.put(x/2, looking.get(x/2)-1);
                if (looking.get(x/2) == 0) looking.remove(x/2);
                ans[ptr++] = x/2;
            } else {
                // System.out.println("?" + x);
                looking.put(x, looking.getOrDefault(x, 0) + 1);
            }
        }  
        if (looking.size() != 0) return new int[0];
        return ans;
    }
}