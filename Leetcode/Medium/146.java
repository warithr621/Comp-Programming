// https://leetcode.com/problems/lru-cache/

import java.util.*;

class LRUCache {

	class Node {
		int key, value;
		Node prev, next;
		Node(int k, int v) {
			key = k;
			value = v;
		}
	}

	private int capacity;
	private Map<Integer, Node> map;
	private Node head, tail;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();
		head = new Node(0, 0);
		tail = new Node(0, 0);
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		if (!map.containsKey(key)) return -1;
		Node node = map.get(key);
		remove(node);
		insertToTail(node);
		return node.value;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			node.value = value;
			remove(node);
			insertToTail(node);
		} else {
			if (map.size() == capacity) {
				Node lru = head.next;
				remove(lru);
				map.remove(lru.key);
			}
			Node node = new Node(key, value);
			insertToTail(node);
			map.put(key, node);
		}
	}

	private void remove(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	private void insertToTail(Node node) {
		node.prev = tail.prev;
		node.next = tail;
		tail.prev.next = node;
		tail.prev = node;
	}
}