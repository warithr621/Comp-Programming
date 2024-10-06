// https://leetcode.com/problems/sentence-similarity-iii/description/?envType=daily-question&envId=2024-10-06

class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s = sentence1.split(" "), t = sentence2.split(" ");
        int L = 0, R1 = s.length - 1, R2 = t.length - 1;
        if (s.length > t.length) return areSentencesSimilar(sentence2, sentence1);
        while (L < s.length && s[L].equals(t[L])) ++L;
        while (R1 >= 0 && s[R1].equals(t[R2])) {
            --R1; --R2;
        }
        return R1 < L;
    }
}