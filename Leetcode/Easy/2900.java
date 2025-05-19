class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        // just start on the first one and alternate?
        List<String> al = new ArrayList<>();
        al.add(words[0]);
        int prevIdx = 0;
        for (int i = 1; i < groups.length; i++) {
            if (groups[prevIdx] != groups[i]) {
                al.add(words[i]);
                prevIdx = i;
            }
        }
        return al;
    }
}