// https://leetcode.com/problems/longest-common-prefix/description/


class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        });
        for (int i = 0; i < strs[0].length(); i++) {
            String tmp = new StringBuilder(ans).append(strs[0].charAt(i)).toString();
            boolean works = true;
            for (String s : strs) {
                works &= s.substring(0, i+1).equals(tmp);
            }
            if (works) ans = new StringBuilder(tmp);
            else break;
        }
        return ans.toString();
    }
}