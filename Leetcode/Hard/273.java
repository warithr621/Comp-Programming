// https://leetcode.com/problems/integer-to-english-words/description/?envType=daily-question&envId=2024-08-07

class Solution {

    public String helper(int num) {
        // we need this helper just because zero is so weird
        StringBuilder ans = new StringBuilder();
        int billion = (int) 1e9, million = (int) 1e6, thousand = 1000;
        String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", 
            "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", 
            "Eighty", "Ninety"};
        String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", 
            "Eight", "Nine"};
        if (num >= billion) {
            String s = helper(num % billion);
            ans.append(helper(num / billion)).append(" Billion");
            ans.append(s.length() == 0 ? "" : " " + s);
        } else if (num >= million) {
            String s = helper(num % million);
            ans.append(helper(num / million)).append(" Million");
            ans.append(s.length() == 0 ? "" : " " + s);
        } else if (num >= thousand) {
            String s = helper(num % thousand);
            ans.append(helper(num / thousand)).append(" Thousand");
            ans.append(s.length() == 0 ? "" : " " + s);
        } else if (num >= 100) {
            String s = helper(num % 100);
            ans.append(helper(num / 100)).append(" Hundred");
            ans.append(s.length() == 0 ? "" : " " + s);
        } else if (10 <= num && num <= 19) {
            ans.append(teens[num - 10]);
        }
        else if (num < 10) ans.append(ones[num]);
        else if (num % 10 == 0) ans.append(tens[num / 10]);
        else ans.append(tens[num / 10]).append(" ").append(ones[num % 10]);
        return ans.toString();
    }

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return helper(num);
    }
}