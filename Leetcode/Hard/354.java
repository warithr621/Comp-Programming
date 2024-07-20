// https://leetcode.com/problems/russian-doll-envelopes/description/

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Envelope[] arr = new Envelope[n];
        for (int i = 0; i < n; i++) arr[i] = new Envelope(envelopes[i][0], envelopes[i][1]);
        Arrays.sort(arr);
        // now this just becomes an LIS problem
        List<Integer> ll = new LinkedList<>();
        ll.add(arr[0].height);
        for (int i = 1; i < n; i++) {
            if (arr[i].height > ll.getLast()) ll.add(arr[i].height);
            else {
                int idx = Collections.binarySearch(ll, arr[i].height);
                if (idx < 0) idx = -idx - 1;
                ll.set(idx, arr[i].height);
            }
        }
        return ll.size();
    }
}

class Envelope implements Comparable<Envelope> {
    int width, height;
    Envelope(int w, int h) {
        this.width = w;
        this.height = h;
    }
    public int compareTo(Envelope e) {
        if (this.width != e.width) return this.width - e.width;
        return -(this.height - e.height);
        // sort by ascending width, and on ties by DESCENDING height
    }
    public boolean equals(Envelope e) {
        return this.width == e.width && this.height == e.height;
    }
}