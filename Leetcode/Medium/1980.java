// https://leetcode.com/problems/find-unique-binary-string/description/?envType=daily-question&envId=2025-02-20

class Solution {

    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        List<Integer> al = new ArrayList<Integer>();
        for (String s : nums) {
            al.add(Integer.parseInt(s, 2));
        }
        Collections.sort(al);
        for (int i = 0; i < n; i++) {
            if (al.get(i) != i) {
                String ans = Integer.toString(i, 2);
                return "0".repeat(n - ans.length()) + ans;
            }
        }
        String ans = Integer.toString((1 << n) - 1, 2);
        return "0".repeat(n - ans.length()) + ans;
    }

    public String better(String[] nums) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            ans.append(nums[i].charAt(i) == '0' ? '1' : '0');
            // for each string, guarantee one of the digits is different
        }
        return ans.toString();
    }

}