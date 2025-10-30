// https://leetcode.com/problems/fraction-to-recurring-decimal/

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder frac = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) frac.append("-");

        long dividend = Math.abs((long) numerator);
        long divisor = Math.abs((long) denominator);
        frac.append(dividend/divisor);
        long remainder = dividend % divisor;
        if (remainder == 0) return frac.toString();

        frac.append(".");
        Map<Long, Integer> hm = new HashMap<>();
        while (remainder != 0) {
            if (hm.containsKey(remainder)) {
                frac.insert(hm.get(remainder), "(");
                frac.append(")");
                break;
            }
            hm.put(remainder, frac.length());
            remainder *= 10;
            frac.append(remainder / divisor);
            remainder %= divisor;
        }
        return frac.toString();
    }
}