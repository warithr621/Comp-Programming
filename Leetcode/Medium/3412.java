// contest

class Solution {
    public long calculateScore(String s) {
        // what if I made 26 priorityqueues
        ArrayList<PriorityQueue<Integer>> al = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            al.add(new PriorityQueue<>(Collections.reverseOrder()));
        }
        long ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a', goal = 25 - idx;
            if (al.get(goal).isEmpty()) {
                al.get(idx).add(i);
            } else {
                ans += i - al.get(goal).poll();
            }
        }
        return ans;
    }
}