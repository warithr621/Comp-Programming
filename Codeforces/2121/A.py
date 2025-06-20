for _ in range(int(input())):
	n, s = map(int, input().split())
	x = [*map(int, input().split())]
	print(min(abs(x[-1] - s), abs(x[0] - s)) + abs(x[0] - x[-1]))