import sys
input = sys.stdin.readline
MOD = 998244353

def inv(n):
	return pow(n, MOD - 2, MOD)

def solve():
	#code
	n, m = map(int, input().split())
	a = []
	for _ in range(n):
		l, r, p, q = map(int, input().split())
		a.append((l, r, p, q))

	monkey = [[] for _ in range(m+1)]
	zn, zd = 1, 1
	for l, r, p, q in a:
		zn = zn * ((q-p) % MOD) % MOD
		zd = zd * (q % MOD) % MOD
		w = (p % MOD) * inv((q-p) % MOD) % MOD
		monkey[r].append((l, w))

	dp = [0 for _ in range(m+1)]
	dp[0] = 1
	for j in range(1, m+1):
		v = 0
		for l, w in monkey[j]:
			v = (v + dp[l-1] * w) % MOD
		dp[j] = v

	print((zn * inv(zd) % MOD) * dp[m] % MOD)

t = 1
for quack in range(t):
	solve()
