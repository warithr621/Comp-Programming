// https://leetcode.com/problems/combinations/

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        // passes, but VERY inefficient
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Item> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(new Item(i));
        }
        while (!q.isEmpty()) {
            Item it = q.poll();
            if (it.size() == k) {
                ans.add(it.nums);
                continue;
            }
            if (it.prev == n) continue;
            for (int i = it.prev + 1; i <= n; i++) {
                Item next = new Item(it);
                next.add(i);
                q.add(next);
            }
        }
        return ans;
    }
}

class Item {
    int prev;
    ArrayList<Integer> nums;
    Item() {
        prev = -1;
        nums = new ArrayList<>();
    }
    Item(int x) {
        prev = x;
        nums = new ArrayList<>();
        nums.add(x);
    }
    Item(Item i) {
        this.prev = i.prev;
        this.nums = (ArrayList<Integer>) i.nums.clone();
    }
    public int size() {
        return nums.size();
    }
    public void add(int x) {
        nums.add(x);
        prev = x;
    }
    public String toString() {
        return prev + " " + nums;
    }
}