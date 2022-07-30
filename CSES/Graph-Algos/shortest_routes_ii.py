# CSES Shortest Routes II

import sys
read = sys.stdin.readline
write = sys.stdout.write

n,m,q = map(int, read().split())

adj = []
for i in range(n):
	adj.append([])
	for j in range(n):
		adj[i].append(int(1e18))

for _ in range(m):
	a,b,c = map(int, read().split())
	a -= 1
	b -= 1
	if c < adj[a][b]:
		adj[a][b] = adj[b][a] = c

for k in range(n):
	for i in range(n):
		for j in range(i+1, n):
			if adj[i][k] + adj[k][j] < adj[i][j]:
				# i->k->j is better than i->j
				adj[i][j] = adj[j][i] = adj[i][k] + adj[k][j]

for _ in range(q):
	src,dest = map(int, read().split())
	ans = adj[src-1][dest-1]
	if src == dest: ans = 0;
	if ans == 1e18: ans = -1;
	write(str(ans) + '\n')
