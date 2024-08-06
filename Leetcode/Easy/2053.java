// https://leetcode.com/problems/kth-distinct-string-in-an-array/description/?envType=daily-question&envId=2024-08-05

class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> freq = new HashMap<>();
        for (String s : arr) {
            freq.put(s, freq.getOrDefault(s, 0) + 1);
        }
        int counter = 0;
        for (String s : arr) {
            if (freq.get(s) == 1) ++counter;
            if (counter == k) return s;
        }
        return "";
    }
}