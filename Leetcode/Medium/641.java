// https://leetcode.com/problems/design-circular-deque/?envType=daily-question&envId=2024-09-28

class Node {
    public int val;
    public Node prev, next;
    public Node(int v, Node p, Node n) {
        this.val = v;
        this.prev = p;
        this.next = n;
    }
}

class MyCircularDeque {

    Node head, end;
    int sz, mx;

    public MyCircularDeque(int k) {
        sz = 0;
        mx = k;
    }
    
    public boolean insertFront(int value) {
        if (sz == mx) return false;
        if (head == null) {
            head = new Node(value, null, null);
            end = head;
        } else {
            Node newFront = new Node(value, null, head);
            head.prev = newFront;
            head = newFront;
        }
        ++sz;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (sz == mx) return false;
        if (head == null) {
            head = new Node(value, null, null);
            end = head;
        } else {
            end.next = new Node(value, end, null);
            end = end.next;
        }
        ++sz;
        return true;
    }
    
    public boolean deleteFront() {
        if (sz == 0) return false;
        if (sz == 1) {
            head = null;
            end = null;
        } else {
            head = head.next;
        }
        --sz;
        return true;
    }
    
    public boolean deleteLast() {
        if (sz == 0) return false;
        if (sz == 1) {
            head = null;
            end = null;
        } else {
            end = end.prev;
        }
        --sz;
        return true;
    }
    
    public int getFront() {
        return (sz == 0 ? -1 : head.val);
    }
    
    public int getRear() {
        return (sz == 0 ? -1 : end.val);
    }
    
    public boolean isEmpty() {
        return sz == 0;
    }
    
    public boolean isFull() {
        return sz == mx;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */