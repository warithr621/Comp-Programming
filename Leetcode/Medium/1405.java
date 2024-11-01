// https://leetcode.com/problems/longest-happy-string/description/?envType=daily-question&envId=2024-10-16

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder ans = new StringBuilder();
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> y.x - x.x);
        if (a > 0) pq.add(new Pair(a, 'a'));
        if (b > 0) pq.add(new Pair(b, 'b'));
        if (c > 0) pq.add(new Pair(c, 'c'));
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int freq = p.x;
            char add = p.c;
            if (ans.length() >= 2 && ans.substring(ans.length()-2).equals((""+add).repeat(2))) {
                if (pq.isEmpty()) break;
                Pair tmp = pq.poll();
                ans.append(tmp.c);
                if (tmp.x > 1) pq.add(new Pair(tmp.x - 1, tmp.c));
            } else {
                --freq;
                ans.append(add);
            }
            if (freq > 0) pq.add(new Pair(freq, add));
        }
        return ans.toString();
    }
}

class Pair {
    int x;
    char c;

    Pair (int x, char c) {
        this.x = x;
        this.c = c;
    }
}