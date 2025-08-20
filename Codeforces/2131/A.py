for _ in range(int(input())):
	n = int(input())
	a = [*map(int, input().split())]
	b = [*map(int, input().split())]
	c = [max(0, a[i] - b[i]) for i in range(n)]
	print(sum(c) + 1)