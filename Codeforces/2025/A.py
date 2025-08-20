def solve():
	#code
	s = input().strip()
	t = input().strip()
	l, n, m = 0, len(s), len(t)
	for i in range(1, min(n,m) + 1):
		if s[:i] == t[:i]:
			l = i
	print(n + m - max(l, 1) + 1)

t = int(input())
for quack in range(t):
	solve()
