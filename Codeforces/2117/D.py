for _ in range(int(input())):
	n = int(input())
	a = [0] + [*map(int, input().split())]
	# we can either decrement by 1,2,3,...n or by n,n-1,n-2,...1
	# we have x + ny = a[1] and 2x + (n-1)y = a[2]
	# solve, then check if everything else works
	# x = a[1] - ny, so 2(a[2] - ny) + (n-1)y = a[2]
	# 2 * a[1] - (n+1)y = a[2]
	y = 2 * a[1] - a[2]
	if y % (n+1) != 0:
		print("NO")
		continue
	y //= n+1
	x = a[1] - n * y
	if x < 0 or y < 0:
		print("NO")
		continue
	# print(x,y)
	works = True
	for i in range(1, n+1):
		if a[i] != i * x + (n-i+1) * y:
			works = False
			break
	print("YES" if works else "NO")