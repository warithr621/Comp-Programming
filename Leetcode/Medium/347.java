// https://leetcode.com/problems/top-k-frequent-elements/description/


class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int x : nums) hm.put(x, hm.getOrDefault(x, 0) + 1);
        ArrayList<Integer> al = new ArrayList<>(hm.keySet());
        Collections.sort(al, new Comparator<Integer>() {
            public int compare(Integer x, Integer y) {
                return hm.get(y) - hm.get(x);
            }
        });
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) ans[i] = al.get(i);
        return ans;
    }
}