import sys, io, os
input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
write = sys.stdout.write
MOD = 10**9 + 7
INV2 = (MOD + 1) // 2

for _ in range(int(input())):
	n, m, k = map(int, input().split())
	# let dp[i][j] be ending score with i rounds and at least j additions
	dp = [[0 for _ in range(m+1)] for _ in range(n+1)]
	for i in range(1, m+1):
		dp[i][i] = i * k % MOD
	for i in range(1, n+1):
		for j in range(1, m+1):
			if i == j:
				continue
			dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % MOD * INV2 % MOD
	write(str(dp[n][m]) + '\n')