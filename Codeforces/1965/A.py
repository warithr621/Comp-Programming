for _ in range(int(input())):
	n = int(input())
	a = [*map(int, input().split())]
	a = set(a)
	mx = max(a)
	MEX = 1
	while MEX in a:
		MEX += 1
	print("Alice" if min(mx, MEX) % 2 == 1 else "Bob")