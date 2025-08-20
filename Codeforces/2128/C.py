def in_li(num=True):
	return [*map(int if num else str, input().split())]

def solve():
	#code
	n = int(input())
	b = in_li()
	works = True
	mn = b[0]
	for i in range(1, n):
		if b[i] >= 2*mn:
			works = False
			break
		mn = min(mn, b[i])
	print("yes" if works else "no")

t = int(input())
for quack in range(t):
	solve()
