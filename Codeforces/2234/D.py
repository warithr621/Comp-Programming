def solve():
	#code
	n, k = map(int, input().split())
	a = [int(x) for x in input()]
	b = [int(x) for x in input()]
	sz = (1 << k)+1
	c = [0] * n
	for i in range(n):
		c[i] = a[i] ^ b[i]
	q, r = divmod(sz, 3)
	if k % 2 == 0:
		ans = a.count(0) * a.count(1) * (q + (r >= 1)) \
			+ b.count(0) * b.count(1) * (q + (r >= 2)) \
			+ c.count(0) * c.count(1) * (q)
	else:
		ans = a.count(0) * a.count(1) * (q + (r >= 1)) \
			+ c.count(0) * c.count(1) * (q + (r >= 2)) \
			+ b.count(0) * b.count(1) * (q)
	print(ans)

t = int(input())
for quack in range(t):
	solve()
