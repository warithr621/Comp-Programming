def solve():
	#code
	n = int(input())
	b = [*map(int, input().split())]
	# b.sort()
	print(min(n, sum(b) - (n-1), n - b.count(0)))

t = int(input())
for quack in range(t):
	solve()