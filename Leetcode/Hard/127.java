// https://leetcode.com/problems/word-ladder/

class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        Set<String> dict = new HashSet<>();
        for (String s : wordList) {
            dict.add(s);
        }
        Queue<Object[]> q = new LinkedList<>();
        q.add(new Object[]{beginWord, 1});
        Set<String> seen = new HashSet<>();
        while (!q.isEmpty()) {
            Object[] info = q.poll();
            String word = (String) info[0];
            int dist = (Integer) info[1];
            if (word.equals(endWord)) return dist;
            seen.add(word);
            char[] letters = word.toCharArray();
            for (int i = 0; i < letters.length; i++) {
                char original = letters[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    if (j == original) continue;
                    letters[i] = j;
                    String destination = new String(letters);
                    if (!seen.contains(destination) && dict.contains(destination)) {
                        q.add(new Object[]{destination, dist + 1});
                    }
                }
                letters[i] = original;
            }
        }
        return 0;
    }
}