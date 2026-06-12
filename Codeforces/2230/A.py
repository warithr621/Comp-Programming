for _ in range(int(input())):
	n, a, b = map(int, input().split())
	if a * 3 <= b:
		print(a * n)
	else:
		print((n // 3) * b + min(b, (n % 3) * a))