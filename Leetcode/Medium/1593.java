// https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/description/?envType=daily-question&envId=2024-10-21

class Solution {
    public int maxUniqueSplit(String s) {
        // I think with bitmask, it's doable to do this in O(2^N * N)
        int ans = 1, n = s.length();
        for (int mask = 0; mask < (1 << (n-1)); mask++) {
            List<Integer> chops = new ArrayList<>();
            for (int i = 0; i < n-1; i++)
                if ((mask & (1 << i)) != 0)
                    chops.add(i + 1);
                
            Set<String> pieces = new HashSet<>();
            StringBuilder cur = new StringBuilder();
            for (int i = 0, j = 0; i < s.length(); i++) {
                if (j != chops.size() && chops.get(j) == i) {
                    pieces.add(cur.toString());
                    cur = new StringBuilder();
                    j++;
                }
                cur.append(s.charAt(i));
            }
            if (cur.length() != 0)
                pieces.add(cur.toString());
            if (pieces.size() == chops.size() + 1) {
                ans = Math.max(ans, pieces.size());
                // System.out.println(chops);
            }
        }
        return ans;
    }
}