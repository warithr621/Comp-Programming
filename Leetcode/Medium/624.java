// https://leetcode.com/problems/maximum-distance-in-arrays/description/?envType=daily-question&envId=2024-08-16

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        // there's a chance that the max and min element across everything are in the same array
        int mx = arrays.get(0).get(arrays.get(0).size()-1), mn = arrays.get(0).get(0);
        int ans = 0;
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> l = arrays.get(i);
            int locmin = l.get(0), locmax = l.get(l.size()-1);
            ans = Math.max(ans, Math.max(mx - locmin, locmax - mn));
            mx = Math.max(mx, locmax);
            mn = Math.min(mn, locmin);
        }
        return ans;
    }
}