// https://leetcode.com/problems/subsets/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // add the empty case
        ArrayList<Integer> empty = new ArrayList<>();
        ans.add(empty);
        for (int x : nums) {
            int sz = ans.size();
            for (int i = 0; i < sz; i++) {
                ArrayList<Integer> temp = new ArrayList<>(ans.get(i));
                temp.add(x);
                ans.add(temp);
            }
        }
        return ans;
    }
}