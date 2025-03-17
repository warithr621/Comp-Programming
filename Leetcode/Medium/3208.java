// https://leetcode.com/problems/alternating-groups-ii/description/?envType=daily-question&envId=2025-03-09

class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int ans = 0;
        ArrayList<Integer> al = new ArrayList<>();
        for (int x : colors) al.add(x);
        for (int i = 0; i < k-1; i++) al.add(colors[i]);
        int L = 0, R = 1;
        while (R < al.size()) {
            if (al.get(R) == al.get(R-1)) {
                L = R++;
                continue;
            }
            R++;
            if (R - L < k) continue;
            ans++;
            L++;
        }
        return ans;
    }
}