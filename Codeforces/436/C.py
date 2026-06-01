from collections import deque

def diff(s, t):
	return sum(1 for a, b in zip(s, t) if a != b)

n, m, k, w = map(int, input().split())
levels = []
for _ in range(k):
	l = ''
	for _ in range(n):
		l += input().strip()
	levels.append(l)
# print('\n'.join(levels))
used = []
cost = n * m # initial level
visited = [False] * k
best = [10**18] * k
parent = [-1] * k
type_to_parent = [0] * k
best[0] = 0
for _ in range(k):
	u = -1
	for i in range(k):
		if not visited[i] and (u == -1 or best[i] < best[u]):
			u = i
	visited[u] = True
	if parent[u] != -1:
		used.append((parent[u], u, type_to_parent[u]))
		cost += best[u]
	for v in range(k):
		if not visited[v]:
			d = diff(levels[u], levels[v])
			weight = min(n * m, d * w)
			type = 0 if weight == n * m else 1
			if weight < best[v]:
				best[v] = weight
				parent[v] = u
				type_to_parent[v] = type

print(cost)
# now construct answer
used.sort(key=lambda x: x[2])
tree = [[] for _ in range(k)]
for u, v, type in used:
	tree[u].append((v, type))
	tree[v].append((u, type))
ans = ["1 0"]
seen = [False] * k
seen[0] = True
queue = deque([0])
while queue:
	u = queue.popleft()
	for v, type in tree[u]:
		if not seen[v]:
			ans.append(f"{v+1} {u+1 if type == 1 else 0}")
			queue.append(v)
			seen[v] = True
print('\n'.join(ans))
