// https://leetcode.com/problems/minimum-time-difference/?envType=daily-question&envId=2024-09-16

class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        List<Integer> al = new ArrayList<>();
        for (String s : timePoints) {
            String[] tmp = s.split(":");
            al.add(Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]));
        }
        Collections.sort(al);
        if (al.get(0) == al.get(n-1)) return 0;
        int ans = 100000;
        for (int i = 0; i < n-1; i++) {
            ans = Math.min(ans, al.get(i+1) - al.get(i));
        }
        return Math.min(ans, 1440 + al.get(0) - al.get(n-1));
    }
}