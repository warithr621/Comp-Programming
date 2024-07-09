// https://leetcode.com/problems/hand-of-straights/description/


class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        for (int x : hand) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        while (freq.size() != 0) {
            int x = freq.firstKey();
            for (int i = 0; i < groupSize; i++, x++) {
                if (freq.containsKey(x)) {
                    freq.put(x, freq.get(x) - 1);
                    if (freq.get(x) == 0) freq.remove(x);
                } else return false;
            }
        }
        return true;
    }
}