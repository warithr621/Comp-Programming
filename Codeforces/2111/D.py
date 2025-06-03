def in_li(num=True):
	return [*map(int if num else str, input().split())]

def solve():
	#code
	n, m = map(int, input().split())
	a = in_li()
	a.sort()
	idx = 0
	for i in range(0, n, 2):
		# should flip-flop between the largest two
		print(a[idx], a[~idx], a[idx], a[~idx], a[idx], a[~idx])
		if i + 1 != n:
			print(a[~idx], a[idx], a[~idx], a[idx], a[~idx], a[idx])
		idx += 1

t = int(input())
for quack in range(t):
	solve()