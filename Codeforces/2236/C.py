def solve():
	#code
	a, b, x = map(int, input().split())
	skib = []
	cur = a
	while True:
		skib.append(cur)
		if cur == 0:
			break
		cur //= x
	toilet = []
	cur = b
	while True:
		toilet.append(cur)
		if cur == 0:
			break
		cur //= x
	ans = 10**18
	for i, sa in enumerate(skib):
		for j, sb in enumerate(toilet):
			ans = min(ans, i + j + abs(sa - sb))
	print(ans)

t = int(input())
for quack in range(t):
	solve()
