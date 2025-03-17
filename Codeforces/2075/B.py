# https://codeforces.com/contest/2075/problem/B

for _ in range(int(input())):
	n, k = map(int, input().split())
	a = [*map(int, input().split())]
	if k >= 2:
		a.sort(reverse=True)
		print(sum(a[:k+1]))
	else:
		ans = 0
		for i in range(n-1):
			ans = max(ans, a[i] + a[n-1])
		for i in range(1, n):
			ans = max(ans, a[0] + a[i])
		print(ans)