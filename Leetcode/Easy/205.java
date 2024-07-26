// https://leetcode.com/problems/isomorphic-strings/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] swap = new char[150];
        boolean[] used = new boolean[150];
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i), ct = t.charAt(i);
            if (swap[cs] == 0) {
                if (used[ct]) return false;
                used[ct] = true;
                swap[cs] = ct;
            } else {
                if (swap[cs] != ct) return false;
            }
        }
        return true;
    }
}