def solve():
	#code
	n = int(input())
	a = [[] for _ in range(n)]
	for i in range(1, n+1):
		for j in range(1, n+1):
			a[i-1].append((i-1)*n+j)
	ans = 0
	for i in range(n):
		for j in range(n):
			cur = 0
			dx = [1,0,-1,0]
			dy = [0,1,0,-1]
			for k in range(4):
				x = i+dx[k]
				y = j+dy[k]
				if 0 <= x < n and 0 <= y < n:
					cur += a[x][y]
			ans = max(ans, cur + a[i][j])
	print(ans)

t = int(input())
for quack in range(t):
	solve()
