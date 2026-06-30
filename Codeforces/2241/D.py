def solve():
	#code
	n = int(input())
	a = [*map(int, input().split())]
	b = [*map(int, input().split())]
	diff = [y-x for x, y in zip(a, b)]
	# print(diff)
	# can diff be written as the sum of a bunch of [1,-1,1,...] subarrays?
	running = 0
	for x in diff:
		running += x
		if running < 0:
			print("NO")
			return
	print("YES")


t = int(input())
for quack in range(t):
	solve()
