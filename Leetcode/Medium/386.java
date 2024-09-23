// https://leetcode.com/problems/lexicographical-numbers/description/?envType=daily-question&envId=2024-09-21

class Solution {
    public List<Integer> lexicalOrder(int n) {
        // ???? this is just radix sort--wait nevermind LOL
        List<Integer> ans = new ArrayList<>();
        int cur = 1;
        for (int i = 1; i <= n; i++) {
            ans.add(cur);
            if (cur * 10 <= n) cur *= 10;
            else {
                while (cur % 10 == 9 || cur >= n) cur /= 10;
                ++cur;
            }
        }
        return ans;
    }
}