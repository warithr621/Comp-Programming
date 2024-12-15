// https://leetcode.com/problems/move-pieces-to-obtain-a-string/description/?envType=daily-question&envId=2024-12-05

class Solution {
    public boolean canChange(String start, String target) {
        int len = start.length();
        int L = 0, R = 0;
        while (L < len || R < len) {
            while (L < len && start.charAt(L) == '_') ++L;
            while (R < len && target.charAt(R) == '_') ++R;
            if (L == len || R == len) {
                return L == len && R == len;
            }
            if (start.charAt(L) != target.charAt(R) ||
                start.charAt(L) == 'L' && L < R || 
                start.charAt(L) == 'R' && R < L) {
                    return false;
            }
            ++L; ++R;
        }
        return true;
    }
}