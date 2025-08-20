import sys, io, os
input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
write = sys.stdout.write
MOD = int(1e9+7)

n, l = map(int, input().split())
boards = []
for i in range(n):
	a, b = map(int, input().split())
	boards.append((i,a,b))
	if a != b:
		boards.append((i,b,a))
n = len(boards)
dp = [[0 for _ in range(n)] for _ in range(l+1)]
# dp[i][j] is no. of ways to make a fence of length i
# such that the last board used is board j
for i, (iid,a, b) in enumerate(boards):
	if a <= l:
		dp[a][i] = 1

for i in range(1, l+1):
	for j, (jid,a,b) in enumerate(boards):
		if i < a:
			continue
		for k, (kid,c,d) in enumerate(boards):
			if k != j and jid != kid and d == a:
				dp[i][j] += dp[i - a][k]
				dp[i][j] %= MOD
write(str(sum(dp[-1]) % MOD) + '\n')