// https://leetcode.com/problems/path-with-maximum-probability/?envType=daily-question&envId=2024-08-27

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<Pair<Integer, Double>>> adj = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            double prob = succProb[i];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair<>(v, prob));
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair<>(u, prob));
        }

        double[] mx = new double[n];
        mx[start] = 1;

        PriorityQueue<Pair<Double, Integer>> pq = new PriorityQueue<>((a, b) -> -Double.compare(a.getKey(), b.getKey())); // max-heap :fire:
        pq.add(new Pair<>(1.0, start));
        while (!pq.isEmpty()) {
            Pair<Double, Integer> cur = pq.poll();
            double curprob = cur.getKey();
            int curnode = cur.getValue();
            if (curnode == end) {
                System.gc();
                return curprob;
            }
            for (Pair<Integer, Double> next : adj.getOrDefault(curnode, new ArrayList<>())) {
                int nextnode = next.getKey();
                double pathprob = next.getValue();
                if (curprob * pathprob > mx[nextnode]) {
                    mx[nextnode] = curprob * pathprob;
                    pq.add(new Pair<>(mx[nextnode], nextnode));
                }
            }
        }
        return 0;
    }
}