// https://leetcode.com/problems/generate-parentheses/

import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        Queue<Value> q = new LinkedList<>();
        Value start = new Value(); start.add('(');
        q.add(start);
        while (!q.isEmpty()) {
            Value v = q.poll();
            if (v.comb().length() == 2*n) {
                if (v.balance() == 0) ans.add(v.comb());
                continue;
            }
            Value l = new Value(v), r = new Value(v);
            l.add('('); r.add(')');
            if (l.balance() >= 0 && v.left != n) q.add(l);
            if (r.balance() >= 0 && r.right <= n) q.add(r);
        }
        return ans;
    }
}

class Value {
    StringBuilder current;
    int left, right;
    Value() {
        current = new StringBuilder();
        left = right = 0;
    }
    Value(Value v) {
        current = new StringBuilder(v.comb());
        left = v.left;
        right = v.right;
    }
    void add(char c) {
        current.append(c);
        if (c == '(') ++left;
        else ++right;
    }
    int balance() {
        return left - right;
    }
    String comb() {
        return current.toString();
    }
    public String toString() {
        return this.comb();
    }
}