// https://leetcode.com/problems/check-if-n-and-its-double-exist/description/?envType=daily-question&envId=2024-12-01

class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> hs = new HashSet<>();
        for (int x : arr) {
            if (hs.isEmpty())
                hs.add(x);
            else if (hs.contains(2 * x) || (x % 2 == 0 && hs.contains(x / 2)))
                return true;
            hs.add(x);
        }
        return false;
    }
}