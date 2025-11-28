import sys, io, os
input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
write = sys.stdout.write
MOD = int(1e9+7)

# let dp[i][j] be no. of valid arrays
# that are of length i
# and end with the number j

n, m = map(int, input().split())
a = [int(x) for x in input().decode().strip().split()]
dp = [[0 for _ in range(m+1)] for _ in range(n+1)]

# now let the fun begin sob
for j in range(1, m+1):
	if a[0] == 0 or a[0] == j:
		dp[1][j] = 1
for i in range(2, n+1):
	for j in range(1, m+1):
		if not(a[i-1] == 0 or a[i-1] == j):
			continue
		for k in [j-1, j, j+1]:
			if 1 <= k <= m:
				dp[i][j] = (dp[i][j] + dp[i-1][k]) % MOD

ans = 0
for j in range(1, m+1):
	ans = (ans + dp[n][j]) % MOD
write(str(ans) + '\n')