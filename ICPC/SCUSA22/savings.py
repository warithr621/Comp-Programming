n, m, a, b = map(int, input().split())
ans = 0
adj = [[] for _ in range(n+1)]
for _ in range(m):
	u, v, w = map(int, input().split())
	adj[u].append((v, w))
	adj[v].append((u, w))
	ans += 2*w # you'll see why

# if an edge is on at least one shortest path from a to b
# then min(dist(a,u) + w + dist(v,b), dist(a,v) + w + dist(u,b)) = dist(a,b)
# find all edges that satisfy this

import heapq
def dijkstra(start):
	dist = [float('inf')] * (n+1)
	dist[start] = 0
	pq = [(0, start)]
	while pq:
		d, u = heapq.heappop(pq)
		if d > dist[u]:
			continue
		for v, w in adj[u]:
			if dist[u] + w < dist[v]:
				dist[v] = dist[u] + w
				heapq.heappush(pq, (dist[v], v))
	return dist
da, db = dijkstra(a), dijkstra(b)

for u in range(1, n+1):
	for v, w in adj[u]:
		if min(da[u] + w + db[v], da[v] + w + db[u]) == da[b]:
			# print(u,v,w)
			ans -= w

print(ans >> 1)