# https://codeforces.com/contest/1881/problem/E

for _ in range(int(input())):
	n = int(input())
	a = [*map(int, input().split())]
	dp = [0 for _ in range(n)]
	dp[-1] = 1
	for i in range(n-2, -1, -1):
		f = dp[i+1] + 1
		s = i + a[i] + 1
		if s > n:
			s = n+1
		elif s == n:
			s = 0
		else:
			s = dp[s]
		dp[i] = min(f, s)
	print(dp[0])