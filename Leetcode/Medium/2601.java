// https://leetcode.com/problems/prime-subtraction-operation/?envType=daily-question&envId=2025-01-02

class Solution {

    private boolean prime(int x) {
        if (x <= 1) return false;
        if (x <= 3) return true;
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

    private List<Integer> gen() {
        // causes extra memory
        List<Integer> primes = new ArrayList<>();
        for (int n = 2; n <= 1000; n++) {
            if (prime(n)) primes.add(n);
        }
        return primes;
    }

    public boolean primeSubOperation(int[] nums) {
        List<Integer> primes = gen();
        for (int i = 0; i < nums.length; i++) {
            int idx = Collections.binarySearch(primes, nums[i]);
            if (idx < 0) idx = -(idx + 1) - 1;
            else --idx;
            // primes.get(idx) is the largest prime less than x
            while (idx >= 0) {
                if (i == 0 || nums[i] - primes.get(idx) > nums[i-1]) {
                    nums[i] -= primes.get(idx);
                    break;
                }
                --idx;
            }
            if (i != 0 && nums[i] <= nums[i-1]) return false;
        }
        // System.out.println(Arrays.toString(nums));
        return true;
    }
}