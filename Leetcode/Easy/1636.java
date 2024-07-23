// https://leetcode.com/problems/sort-array-by-increasing-frequency/?envType=daily-question&envId=2024-07-23


class Solution {
    public int[] frequencySort(int[] nums) {
        int[] freq = new int[201];
        HashSet<Integer> hs = new HashSet<>();
        for (int x : nums) {
            freq[x + 100]++;
            hs.add(x);
        }
        ArrayList<Integer> al = new ArrayList<>(hs);
        Collections.sort(al, new Comparator<Integer>() {
            public int compare(Integer x, Integer y) {
                if (freq[x + 100] != freq[y + 100]) {
                    return (freq[x + 100] > freq[y + 100] ? 1 : -1);
                } else return y - x;
            }
        });
        int[] ans = new int[nums.length];
        int idx = 0;
        for (int x : al) {
            for (int i = 0; i < freq[x + 100]; i++) {
                ans[idx++] = x;
            }
        }
        return ans;
    }
}