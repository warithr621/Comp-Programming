// https://leetcode.com/problems/number-of-senior-citizens/?envType=daily-question&envId=2024-08-01

class Solution {
    public int countSeniors(String[] details) {
        int ans = 0;
        for (String s : details) {
            if (Integer.parseInt(s.substring(11, 13)) > 60) ++ans;
        }
        return ans;
    }
}