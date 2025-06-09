for _ in range(int(input())):
	n, x = map(int, input().split())
	a = [*map(int, input().split())]
	print(max(a + [(sum(a) + x - 1) // x]))