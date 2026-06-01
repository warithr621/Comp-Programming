from bisect import bisect_left, insort

class DSU:
	def __init__(self, n):
		self.parent = list(range(n))
		self.size = [1] * n
	def find(self, a):
		if self.parent[a] != a:
			self.parent[a] = self.find(self.parent[a])
		return self.parent[a]
	def unite(self, a, b):
		a = self.find(a)
		b = self.find(b)
		if a == b:
			return False, 0, 0

		if self.size[a] < self.size[b]:
			a, b = b, a
		sa, sb = self.size[a], self.size[b]
		self.parent[b] = a
		self.size[a] += self.size[b]
		return True, sa, sb

n, m = map(int, input().split())
dsu = DSU(n)
sizes = [1] * n
free = 0
for _ in range(m):
	x, y = map(int, input().split())
	merged, sa, sb = dsu.unite(x-1, y-1)
	if not merged:
		free += 1
	else:
		sizes.pop(bisect_left(sizes, sa))
		sizes.pop(bisect_left(sizes, sb))
		insort(sizes, sa + sb)
	print(sum(sizes[-(free+1):]) - 1)