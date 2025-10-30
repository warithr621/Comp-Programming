for _ in range(int(input())):
	n, m, k = map(int, input().split())
	if n * (n-1) // 2 < m or m < n-1:
		print("no")
		continue
	if n == 1:
		print("Yes" if k > 1 else "No")
	elif m < n * (n-1) // 2:
		print("yeS" if k > 3 else "nO")
	elif k > 2:
		print("YeS")
	else:
		print("NO")