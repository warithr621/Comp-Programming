// https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/description/?envType=daily-question&envId=2024-12-02

class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String check = words[i];
            if (check.length() < searchWord.length())
                continue; // cannot be prefix
            if (searchWord.equals(check.substring(0, searchWord.length())))
                return i+1;
        }
        return -1;
    }
}