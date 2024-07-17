// https://leetcode.com/problems/ransom-note/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[][] f = new int[26][2];
        for (char c : ransomNote.toCharArray()) f[c - 'a'][0]++;
        for (char c : magazine.toCharArray()) f[c - 'a'][1]++;
        boolean ans = true;
        for (int[] arr : f) ans &= (arr[0] <= arr[1]);
        return ans;
    }
}