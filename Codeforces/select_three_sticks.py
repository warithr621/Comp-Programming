# https://codeforces.com/contest/1734/problem/A

for _ in range(int(input())):
	n = int(input())
	a = sorted(list(map(int, input().split())))
	ans = 2e9
	for i in range(2, n):
		ans = min(ans, a[i] - a[i-2])
	print(ans)