// https://leetcode.com/problems/word-subsets/description/?envType=daily-question&envId=2025-01-10

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        // multiplicity matters which is really important
        int[] bfreq = new int[26];
        for (String b : words2) {
            int[] tmp = new int[26];
            for (char c : b.toCharArray()) tmp[c - 'a']++;
            for (int i = 0; i < 26; i++) {
                bfreq[i] = Math.max(bfreq[i], tmp[i]);
            }
        }
        List<String> ans = new ArrayList<>();
        for (String a : words1) {
            int[] afreq = new int[26];
            for (char c : a.toCharArray()) afreq[c - 'a']++;
            boolean w = true;
            for (int i = 0; i < 26; i++) {
                w &= (afreq[i] >= bfreq[i]);
            }
            if (w) ans.add(a);
        }
        return ans;
    }
}