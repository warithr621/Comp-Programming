class Node:
	def __init__(self, val):
		self.val = val
		self.left = None
		self.right = None

def max_cartesian_tree(arr):
	stack = []
	for x in arr:
		cur = Node(x)
		last = None
		while stack and stack[-1].val < x:
			last = stack.pop()
		cur.left = last
		if stack:
			stack[-1].right = cur
		stack.append(cur)
	return stack[0] if stack else None

def height(tree):
	if not tree:
		return 0
	stack = [(tree, 1)]
	ans = 0
	while stack:
		node, h = stack.pop()
		ans = max(ans, h)
		if node.left:
			stack.append((node.left, h + 1))
		if node.right:
			stack.append((node.right, h + 1))
	return ans

for _ in range(int(input())):
	n = int(input())
	a = [*map(int, input().split())]
	print(n - height(max_cartesian_tree(a)))