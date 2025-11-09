// https://leetcode.com/problems/count-binary-substrings/description/

class Solution {
    public int countBinarySubstrings(String s) {
        // count the groups
        char cur = s.charAt(0);
        int run = 0;
        List<Integer> al = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (c == cur) ++run;
            else {
                al.add(run);
                run = 1;
                cur = c;
            }
        }
        al.add(run);

        int ans = 0;
        for (int i = 0; i < al.size()-1; i++) {
            ans += Math.min(al.get(i), al.get(i+1));
        }
        return ans;
    }
}