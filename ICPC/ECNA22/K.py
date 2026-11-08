import re

class Node:
	def __init__(self):
		self.val = None
		self.children = []
		self.parent = None
	def set(self, val):
		self.val = val
	def add(self, child):
		self.children.append(child)
		child.parent = self

s = re.findall(r"\d+|[\(\)]", input().strip().replace(" ",""))
t = re.findall(r"\d+|[\(\)]", input().strip().replace(" ",""))

# let's construct s first
ts = Node()
for elem in s:
	if elem == '(':
		nxt = Node()
		ts.add(nxt)
		ts = nxt
	elif elem == ')':
		ts = ts.parent
	else:
		ts.set(int(elem))
# then t
tt = Node()
for elem in t:
	if elem == '(':
		nxt = Node()
		tt.add(nxt)
		tt = nxt
	elif elem == ')':
		tt = tt.parent
	else:
		tt.set(int(elem))

# now gotta check are s and t the same (barring any ordering)
def monkey(root, table):
	order, stack = [], [root]
	while stack:
		n = stack.pop()
		order.append(n)
		stack.extend(n.children)

	cid = {}
	for n in reversed(order):
		key = (n.val, tuple(sorted(cid[id(c)] for c in n.children)))
		# ^ marks a node by its value as well as the ids of all the children (sorted for consistency, since hierarchy matters not order)
		cid[id(n)] = table.setdefault(key, len(table))
		# ^ add to our table
	return cid[id(root)]
	# ^ theoretically the root's id should be the same in both cases

table = {}
print("Yes" if monkey(ts, table) == monkey(tt, table) else "No")