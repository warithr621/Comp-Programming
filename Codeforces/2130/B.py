def in_li(num=True):
	return [*map(int if num else str, input().split())]

def solve():
	# code
	n, s = map(int, input().split())
	a = in_li()
	z, o, t = a.count(0), a.count(1), a.count(2)
	if s < sum(a):
		print(*a)
		return
	if sum(a) == s:
		print(-1)
		return
	# now we know the sum of a is more than s
	# is there a way to screw alice up?
	diff = s - sum(a)
	# can we get to diff by spamming numbers?
	# i think it has to be all 0s and all 1s and all 2s together in some way
	# as the only way to stop it ???
	if diff == 1:
		ans = [0] * z + [2] * t + [1] * o
		print(*ans)
	else:
		print(-1)


t = int(input())
for quack in range(t):
	solve()
