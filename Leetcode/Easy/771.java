// https://leetcode.com/problems/jewels-and-stones/

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> hs = new HashSet<>();
        for (char c : jewels.toCharArray()) hs.add(c);
        int ans = 0;
        for (char c : stones.toCharArray()) {
            ans += (hs.contains(c) ? 1 : 0);
        }
        return ans;
    }
}