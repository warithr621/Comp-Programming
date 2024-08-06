// https://leetcode.com/problems/minimum-window-substring/

class Solution {

    public static boolean checker(int[] x, int[] y) {
        for (int i = 0; i < x.length; i++) {
            if (y[i] == 0) continue;
            if (x[i] < y[i]) return false;
        }
        return true;
    }

    public String minWindow(String s, String t) {
        int[] tcnt = new int[128];
        for (char c : t.toCharArray()) tcnt[c]++;
        int[] anscnt = new int[128];
        String ans = "";
        int L = 0, R = 0;
        while (R < s.length()) {
            // add the char at position R
            anscnt[s.charAt(R)]++;
            if (checker(anscnt, tcnt)) {
                // yay!!! first upd ans if possible
                if (ans.length() == 0 || ans.length() > R - L + 1) {
                    ans = s.substring(L, R+1);
                }
                // now we need to keep shifting L
                while (true) {
                    // remove char L
                    anscnt[s.charAt(L)]--;
                    ++L;
                    // now see if the string is still fine
                    if (checker(anscnt, tcnt)) {
                        if (ans.length() > R - L + 1) {
                            ans = s.substring(L, R+1);
                        }
                    } else break;
                }
            }
            ++R;
        }
        return ans;
    }
}