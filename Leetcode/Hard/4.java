// https://leetcode.com/problems/median-of-two-sorted-arrays/

import java.util.*;

class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int left = 0, right = m;
        while (left <= right) {
            int pA = (left + right) / 2;
            int pB = (m + n + 1) / 2 - pA;
            int mxLA = (pA == 0 ? Integer.MIN_VALUE : nums1[pA - 1]);
            int mnRA = (pA == m ? Integer.MAX_VALUE : nums1[pA]);
            int mxLB = (pB == 0 ? Integer.MIN_VALUE : nums2[pB - 1]);
            int mnRB = (pB == n ? Integer.MAX_VALUE : nums2[pB]);
            if (mxLA <= mnRB && mxLB <= mnRA) {
                if ((m + n) % 2 == 0) {
                    int ans = Math.max(mxLA, mxLB) + Math.min(mnRA, mnRB);
                    return ans / 2.0;
                } else {
                    return Math.max(mxLA, mxLB);
                }
            } else if (mxLA > mnRB) {
                right = pA - 1;
            } else {
                left = pA + 1;
            }
        }
        return 0;
    }
}