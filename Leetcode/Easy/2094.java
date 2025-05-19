// https://leetcode.com/problems/finding-3-digit-even-numbers/?envType=daily-question&envId=2025-05-12

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] freq = new int[10];
        for (int x : digits) {
            freq[x]++;
        }
        List<Integer> al = new ArrayList<>();
        for (int i = 100; i < 1000; i += 2) {
            String s = Integer.toString(i);
            for (char c : s.toCharArray()) freq[c - '0']--;
            boolean works = true;
            for (char c : s.toCharArray()) {
                works &= freq[c - '0'] >= 0;
            }
            for (char c : s.toCharArray()) freq[c - '0']++;
            if (works) al.add(i);
        }
        int[] ans = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            ans[i] = al.get(i);
        }
        return ans;
    }
}