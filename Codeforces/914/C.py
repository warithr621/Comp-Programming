import sys, io, os
input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
write = sys.stdout.write
MOD = int(1e9+7)


fact = [1 for _ in range(1001)]
invfact = [1 for _ in range(1001)]
for i in range(1, 1001):
	fact[i] = (fact[i-1] * i) % MOD
invfact[1000] = pow(fact[1000], MOD-2, MOD)
for i in range(999, 0, -1):
	invfact[i] = (invfact[i+1] * (i+1)) % MOD
def nCr(n, r):
	if r > n or r < 0:
		return 0
	return (fact[n] * invfact[r] % MOD) * invfact[n-r] % MOD

dp = [-1 for _ in range(1001)]
dp[1] = 0
def steps(n):
	if dp[n] != -1:
		return dp[n]
	bits = bin(n).count('1')
	dp[n] = steps(bits) + 1
for i in range(2, 1001):
	steps(i)


s = input().decode().strip()
n, k = len(s), int(input())
# digit dp :(
cnt = [0] * (n + 1)
running = 0
for i, ch in enumerate(s):
	if ch == '1':
		r = n - i - 1
		for j in range(running, min(n, running + r) + 1):
			need = j - running
			if 0 <= need <= r:
				cnt[j] += nCr(r, need)
		running += 1
if running <= n:
	cnt[running] += 1

ans = sum(cnt[i] for i in range(n+1) if dp[i] == k - 1) % MOD
write(str(ans - (1 if k == 1 else 0)) + '\n')