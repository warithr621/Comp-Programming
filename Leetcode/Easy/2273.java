// https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/

class Solution {

    public boolean check(String s, String t) {
        int[] f = new int[26];
        for (char c : s.toCharArray()) f[c - 'a']++;
        for (char c : t.toCharArray()) f[c - 'a']--;
        for (int x : f) {
            if (x != 0) return false;
        }
        return true;
    }

    public List<String> removeAnagrams(String[] words) {
        Stack<String> st = new Stack<>();
        for (String s : words) {
            if (st.isEmpty() || !check(st.peek(), s)) st.push(s); 
        }
        return (List<String>) st;
    }
}