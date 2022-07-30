# CSES Counting Towers

MOD = 1000000007
dp = []
for _ in range(1000001): dp.append([0, 0])
dp[1] = [1, 1]
for i in range(2, 1000001):
	dp[i][0] = 2 * dp[i-1][0] + dp[i-1][1]
	dp[i][1] = 4 * dp[i-1][1] + dp[i-1][0]
	dp[i][0] %= MOD
	dp[i][1] %= MOD
 
for _ in range(int(input())):
	n = int(input())
	print((dp[n][0] + dp[n][1]) % MOD)