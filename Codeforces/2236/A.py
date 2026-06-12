def solve():
	#code
	n = int(input())
	a = [*map(int, input().split())]
	print(max(a) - min(a) + 1)

t = int(input())
for quack in range(t):
	solve()
