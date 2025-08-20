def in_li(num=True):
	return [*map(int if num else str, input().split())]

def solve():
	# code
	n = int(input())
	a = in_li()
	a.sort()
	# you can replace all (0,1) pairs with 2
	# and all remaining lone 0s with 1s
	z, o = a.count(0), a.count(1)
	ans = 0
	v = min(z, o)
	ans += 2 * v
	for i in range(v):
		a.remove(0)
		a.remove(1)
	while (z-v) > 0:
		a.remove(0)
		z -= 1
		ans += 1
	print(ans + sum(a))

t = int(input())
for quack in range(t):
	solve()
