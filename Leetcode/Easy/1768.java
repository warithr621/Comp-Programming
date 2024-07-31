// https://leetcode.com/problems/merge-strings-alternately/

class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = word1.length(), m = word2.length(), i = 0, j = 0, ptr = 0;
        char[] arr = new char[n + m];
        while (i < n || j < m) {
            if (i != n) arr[ptr++] = word1.charAt(i++);
            if (j != m) arr[ptr++] = word2.charAt(j++);
        }
        return String.valueOf(arr);
    }
}