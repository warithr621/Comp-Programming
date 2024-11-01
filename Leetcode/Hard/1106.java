// https://leetcode.com/problems/parsing-a-boolean-expression/description/?envType=daily-question&envId=2024-10-20

class Solution {

    public boolean parseBoolExpr(String expression) {
        while (expression.length() > 1) {
            int start = Math.max(expression.lastIndexOf('!'), Math.max(expression.lastIndexOf('&'), expression.lastIndexOf('|')));
            int end = expression.indexOf(')', start);
            String sub = expression.substring(start, end + 1);
            expression = expression.substring(0, start) + eval(sub) + expression.substring(end + 1);
        }
        return expression.equals("t");
    }

    char eval(String exp) {
        char op = exp.charAt(0);
        String vals = exp.substring(2, exp.length() - 1);
        if (op == '!') return vals.charAt(0) == 't' ? 'f' : 't';
        if (op == '&') return vals.contains("f") ? 'f' : 't';
        if (op == '|') return vals.contains("t") ? 't' : 'f';
        return '~';
    }
}