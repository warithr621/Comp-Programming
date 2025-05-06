for _ in range(int(input())):
	n = int(input())
	a = []
	for m in range(n):
		a.append([*map(int, input().split())])
	ans = a[0]
	for i in range(1, n):
		ans.append(a[i][-1])
	print(2*n * (2*n+1) // 2 - sum(ans), end=' ')
	print(' '.join(map(str, ans)))