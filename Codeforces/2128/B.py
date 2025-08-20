def in_li(num=True):
	return [*map(int if num else str, input().split())]

def solve():
	#code
	n = int(input())
	p = in_li()
	ans = []
	l, r = 0, n-1
	for i in range(n):
		if i % 2 == 0:
			if p[l] < p[r]:
				ans.append('L')
				l += 1
			else:
				ans.append('R')
				r -= 1
		else:
			if p[l] < p[r]:
				ans.append('R')
				r -= 1
			else:
				ans.append('L')
				l += 1
	print(''.join(ans))


t = int(input())
for quack in range(t):
	solve()
