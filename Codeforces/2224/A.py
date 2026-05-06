for _ in range(int(input())):
	n = int(input())
	a = [*map(int, input().split())]
	for i in range(n-2, -1, -1):
		if a[i+1] >= 0:
			a[i] += a[i+1]
	print(sum([1 if k > 0 else 0 for k in a]))