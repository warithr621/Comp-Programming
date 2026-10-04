// https://leetcode.com/problems/word-ladder/

class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for (String s : wordList) {
            dict.add(s);
        }
        if (!dict.contains(endWord)) return 0;
        Set<String> begin = new HashSet<>(), end = new HashSet<>();
        begin.add(beginWord); end.add(endWord);
        dict.remove(beginWord); dict.remove(endWord);
        int dist = 1;
        while (!begin.isEmpty() && !end.isEmpty()) {
            if (begin.size() > end.size()) {
                Set<String> temp = begin;
                begin = end;
                end = temp;
            }
            Set<String> next = new HashSet<>();
            for (String word : begin) {
                char[] letters = word.toCharArray();
                for (int i = 0; i < letters.length; i++) {
                    char original = letters[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;
                        letters[i] = c;
                        String destination = new String(letters);
                        if (end.contains(destination)) return dist + 1;
                        if (dict.remove(destination)) next.add(destination);
                    }
                    letters[i] = original;
                }
            }
            begin = next;
            dist++;
        }
        return 0;
    }
}