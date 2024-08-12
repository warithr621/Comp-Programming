// https://leetcode.com/problems/count-and-say/

class Solution {
    public String countAndSay(int n) {
        StringBuilder ans = new StringBuilder("1");
        for (int v = 2; v <= n; v++) {
            String tmp = ans.toString();
            ans = new StringBuilder();
            char cur = tmp.charAt(0);
            int cnt = 0;
            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) == cur) {
                    ++cnt;
                    // System.out.println("inc");
                } else {
                    // System.out.println("change");
                    ans.append(cnt).append(cur);
                    cur = tmp.charAt(i);
                    cnt = 1;
                }
            }
            ans.append(cnt).append(cur);
            // System.out.println(ans.toString());
        }
        return ans.toString();
    }
}