def in_li(num=True):
	return [*map(int if num else str, input().split())]

def solve():
	n, c = map(int, input().split())
	a = in_li()
	a.sort()
	# always pick the biggest that is <= c
	used = [-1 for _ in range(n)]
	for itr in range(n):
		idx = -1
		for i in range(n):
			if used[i] == -1 and a[i] <= c:
				idx = i
		if idx != -1:
			used[idx] = 0
		else:
			for i in range(n):
				if used[i] == -1:
					used[i] = 1
			break
		for i in range(n):
			a[i] <<= 1
	print(sum(used))

t = int(input())
for quack in range(t):
	solve()
