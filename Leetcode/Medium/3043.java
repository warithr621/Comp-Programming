// https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/?envType=daily-question&envId=2024-09-24

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int ans = 0;
        StringBuilder sb = new StringBuilder();
        HashSet<String> hs = new HashSet<>(), hss = new HashSet<>();
        for (int x : arr1) {
            sb.setLength(0);
            for (char c : Integer.toString(x).toCharArray()) {
                sb.append(c);
                hs.add(sb.toString());
            }
        }
        for (int x : arr2) {
            sb.setLength(0);
            for (char c : Integer.toString(x).toCharArray()) {
                sb.append(c);
                hss.add(sb.toString());
            }
        }
        // System.out.println(hs + " " + hss);
        for (String s : hs) {
            if (hss.contains(s)) {
                ans = Math.max(ans, s.length());
            }
        }
        return ans;
    }
}