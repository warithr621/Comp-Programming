// contest

class Solution {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) return word;
        String best = "";
        for (int i = 0; i < word.length(); i++) {
            String test = word.substring(i, Math.min(i + word.length() - numFriends + 1, word.length()));
            if (best.compareTo(test) < 0) best = test;
        }
        return best;
    }
}