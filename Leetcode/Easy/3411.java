// contest

class Solution {

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    
    public int maxLength(int[] nums) {
        // what the heck
        // smth smth gcd
        int ans = 1;
        for (int start = 0; start < nums.length; start++) {
            long prod = nums[start], lcm = nums[start], g = nums[start];
            for (int end = start + 1; end < nums.length; end++) {
                prod *= nums[end];
                lcm = lcm * nums[end] / gcd(lcm, nums[end]);
                g = gcd(g, nums[end]);
                // System.out.println(start + " " + end + " " + prod + " " + g + " " + lcm);
                if (prod % lcm != 0 || prod / lcm != g) break;
                ans = Math.max(ans, end - start + 1);
            }
        }
        return ans;
    }
}