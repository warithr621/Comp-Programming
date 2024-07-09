// https://leetcode.com/problems/last-stone-weight/

import java.util.*;

class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int x : stones) pq.add(x);
        while (pq.size() >= 2) {
            int x = pq.poll();
            int y = pq.poll();
            if (x != y) {
                pq.add(Math.abs(x - y));
            }
        }
        return pq.size() == 0 ? 0 : pq.peek();
    }
}