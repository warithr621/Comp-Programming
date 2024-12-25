// https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/description/?envType=daily-question&envId=2024-12-18

class Solution {
    public int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    prices[i] -= prices[j];
                    break;
                }
            }
        }
        return prices;
    }

    public int[] monotonic(int[] prices) {
        // O(N) rather than O(N^2) time, but O(N) space vs O(1) space
        // and is actually slower, probably bcz of N being not very large and the push/pop operations
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!st.isEmpty() && prices[st.peek()] >= prices[i]) {
                prices[st.pop()] -= prices[i];
            }
            st.push(i);
        }
        return prices;
    }
}