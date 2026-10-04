// https://leetcode.com/problems/find-median-from-data-stream/

class MedianFinder {

    // have two heaps
    Queue<Integer> left, right;

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder()); // max heap (smallest half)
        right = new PriorityQueue<>(); // min heap (biggest half)
    }
    
    public void addNum(int num) {
        if (left.isEmpty() && right.isEmpty()) {
            left.add(num);
            return;
        }
        if (num < left.peek()) left.add(num);
        else right.add(num);

        if (right.size() > left.size()) {
            left.add(right.poll());
        }
        if (right.size() + 2 == left.size()) {
            right.add(left.poll());
        }
        // System.out.println("After adding " + num + " we have " + left + " and " + right);
    }
    
    public double findMedian() {
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return left.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */