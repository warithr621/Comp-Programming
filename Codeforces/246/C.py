n, k = map(int, input().split())
a = [*map(int, input().split())]
a.sort()
v = n
while k > 0:
	for i in range(min(v, k)):
		p = [n - v + 1]
		for j in range(n-v):
			p.append(a[-(j+1)])
		p.append(a[i])
		print(*p)
	k -= v
	v -= 1