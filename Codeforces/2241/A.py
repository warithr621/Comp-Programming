def solve():
	#code
	x, y = map(int, input().split())
	print("YES" if x % y == 0 else "NO")

t = int(input())
for quack in range(t):
	solve()
