// https://leetcode.com/problems/first-bad-version/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        // literally binary search
        int L = 1, R = n;
        while (L < R) {
            int M = L + ((R - L) >> 1);
            if (isBadVersion(M)) R = M;
            else L = M + 1;
        }
        return L;
    }
}