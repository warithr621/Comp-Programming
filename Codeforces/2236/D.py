from collections import Counter

def solve():
	#code
	n, k = map(int, input().split())
	a = [*map(int, input().split())]
	cnt = Counter(a)
	if any(c % 2 == 0 for c in cnt.values()):
		print("YES")
		return
	vals = sorted(cnt)
	good = any(vals[i+1] - vals[i] <= k for i in range(len(vals) - 1))
	print("YES" if good else "NO")


t = int(input())
for quack in range(t):
	solve()
