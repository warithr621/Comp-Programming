// https://leetcode.com/problems/different-ways-to-add-parentheses/?envType=daily-question&envId=2024-09-19

class Solution {

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList<>();
        if (expression.length() == 0) return ans;
        if (expression.length() == 1) {
            ans.add(Integer.parseInt(expression));
            return ans;
        }
        if (
            expression.length() == 2 && Character.isDigit(expression.charAt(0))) {
            ans.add(Integer.parseInt(expression));
            return ans;
        }

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) continue;
            List<Integer> leftResults = diffWaysToCompute(expression.substring(0, i));
            List<Integer> rightResults = diffWaysToCompute(expression.substring(i + 1));

            for (int l : leftResults) {
                for (int r : rightResults) {
                    int val = 0;

                    // Perform the operation based on the current character
                    switch (c) {
                        case '+':
                            val = l + r;
                            break;
                        case '-':
                            val = l - r;
                            break;
                        case '*':
                            val = l * r;
                            break;
                    }

                    ans.add(val);
                }
            }
        }

        return ans;
    }
}