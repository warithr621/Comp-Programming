import sys, io, os
input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
write = sys.stdout.write
MOD = 998_244_353

def solve():
	#code
	n, m = map(int, input().split())
	n -= 1
	need = [0] * (n+1)
	for _ in range(m):
		l, r = map(int, input().split())
		r -= 1
		need[r] = max(need[r], l)

	dp = [0] * (n+1)
	dp[0] = 1
	tot, cur = 1, 0
	# for each i, dp[j] will be no. of strings of length i
		# such that the last 1 is at position j
	for i in range(1, n+1):
		dp[i] = tot % MOD
		tot = (tot + dp[i]) % MOD
		if need[i] > cur:
			for j in range(cur, need[i]):
				tot = (tot - dp[j]) % MOD
				dp[j] = 0
			cur = need[i]
	write(str(tot % MOD * 2 % MOD) + '\n')


t = int(input())
for quack in range(t):
	solve()