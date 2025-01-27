// https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/description/?envType=daily-question&envId=2025-01-25

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int N = nums.length;
        int[] sortedA = new int[N];
        for (int i = 0; i < N; i++) sortedA[i] = nums[i];
        Arrays.sort(sortedA);

        int group = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(sortedA[0], group);
        Map<Integer, LinkedList<Integer>> conv = new HashMap<>();
        conv.put(group, new LinkedList<Integer>(Arrays.asList(sortedA[0])));
        for (int i = 1; i < N; i++) {
            if (Math.abs(sortedA[i] - sortedA[i-1]) > limit) ++group;
            hm.put(sortedA[i], group);
            if (!conv.containsKey(group)) {
                conv.put(group, new LinkedList<>());
            }
            conv.get(group).add(sortedA[i]);
        }

        for (int i = 0; i < N; i++) {
            int x = nums[i];
            int g = hm.get(x);
            nums[i] = conv.get(g).pop();
        }
        return nums;
    }
}