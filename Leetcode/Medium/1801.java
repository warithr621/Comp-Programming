// https://leetcode.com/problems/number-of-orders-in-the-backlog/description/

class Solution {

    public int getNumberOfBacklogOrders(int[][] orders) {
        long MOD = 1_000_000_007;
        // when we buy, we want to look at smallest sell
        // when we sell, we want to look at the biggest buy
        // (price, amt)
        Queue<int[]> buys = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        Queue<int[]> sells = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (int[] order : orders) {
            int price = order[0], amount = order[1], type = order[2];
            if (type == 0) {
                // buy
                while (amount != 0 && !sells.isEmpty() && sells.peek()[0] <= price) {
                    int[] prev = sells.poll();
                    int match = Math.min(amount, prev[1]);
                    amount -= match;
                    prev[1] -= match;
                    if (prev[1] != 0) sells.add(prev);
                }
                if (amount != 0) buys.add(new int[]{price, amount});
            } else {
                // sell
                while (amount != 0 && !buys.isEmpty() && buys.peek()[0] >= price) {
                    int[] prev = buys.poll();
                    int match = Math.min(amount, prev[1]);
                    amount -= match;
                    prev[1] -= match;
                    if (prev[1] != 0) buys.add(prev);
                }
                if (amount != 0) sells.add(new int[]{price, amount});
            }
        }
        long ans = 0;
        while (!buys.isEmpty()) ans += buys.poll()[1];
        while (!sells.isEmpty()) ans += sells.poll()[1];
        return (int) (ans % MOD);
    }
}