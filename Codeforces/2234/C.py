def solve():
	#code
	n = int(input())
	h = [*map(int, input().split())]
	# for C this can be done in O(N^2) and pass
	ans = [0] * n
	for l in range(n):
		# fix w_l = 0
		pfx, sfx = [0] * n, [0] * n
		pfx[0] = h[l]
		for k in range(1, n):
			pfx[k] = max(pfx[k-1], h[(l+k)%n])
		sfx[0] = h[(l-1+n)%n]
		for k in range(1, n):
			sfx[k] = max(sfx[k-1], h[(l-k-1+n)%n])
		# print(pfx, sfx)
		for k in range(1, n):
			ans[l] += min(pfx[k-1], sfx[n-k-1])
	print(*ans)
	

t = int(input())
for quack in range(t):
	solve()