import sys
read = sys.stdin.readline
write = sys.stdout.write

class DSU:
	__slots__ = ['parent', 'size']
	def __init__(self, n):
		self.parent = list(range(n))
		self.size = [1] * n
	def find(self, a):
		if self.parent[a] != a:
			self.parent[a] = self.find(self.parent[a])
		return self.parent[a]
	def unite(self, a, b):
		a, b = self.find(a), self.find(b)
		if a != b:
			if self.size[a] < self.size[b]:
				a, b = b, a
			self.parent[b] = a
			self.size[a] += self.size[b]
	def connected(self, a, b):
		return self.find(a) == self.find(b)

def build(n, edges):
	dsu = DSU(n)
	for a, b in edges:
		dsu.unite(a, b)
	return dsu

for _ in range(int(read())):
	n, m1, m2 = map(int, read().split())
	f, g = [], []
	for _ in range(m1):
		u, v = map(int, read().split())
		f.append((u - 1, v - 1))
	for _ in range(m2):
		u, v = map(int, read().split())
		g.append((u - 1, v - 1))
	# if path not in F, path not in G
		# create a DSU of G first
		# if an edge in F connects two separate components in G, remove it
	# if path in F, path in G
		# create a DSU of F
		# if an edge in G connects two separate components in F, add it
	ans = 0
	dg = build(n, g)
	tmp = [(u,v) for u,v in f if dg.connected(u, v)]
	ans += len(f) - len(tmp)
	f = tmp
	df = build(n, f)
	for u, v in g:
		if not df.connected(u, v):
			df.unite(u, v)
			ans += 1
	write(str(ans) + '\n')