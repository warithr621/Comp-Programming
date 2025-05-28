def monkey(x, y):
	ret = 0
	while x > 1 or y > 1:
		if x > y:
			x = (x+1)//2
		else:
			y = (y+1)//2
		ret += 1
	return ret

for _ in range(int(input())):
	n, m, a, b = map(int, input().split())
	# always cut bigger side?
	# *lets instead just check each of the four original cuts, and see what happens
	ans = min(monkey(n-a+1, m), monkey(a, m), monkey(n, m-b+1), monkey(n, b))
	print(1+ans)