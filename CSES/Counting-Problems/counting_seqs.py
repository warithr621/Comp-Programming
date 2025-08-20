import sys, io, os
input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
write = sys.stdout.write
MOD = int(1e9+7)

n, k = map(int, input().split())
fact = [1] * (k+1)
for i in range(1, k+1):
	fact[i] = fact[i-1] * i % MOD
invfact = [1] * (k+1)
invfact[k] = pow(fact[k], MOD-2, MOD)
for i in range(k, 0, -1):
	invfact[i-1] = invfact[i] * i % MOD

ans = 0
for i in range(k+1):
	c = fact[k] * invfact[i] % MOD * invfact[k-i] % MOD
	v = c * pow(k-i, n, MOD) % MOD
	ans = ans + v * (1 if i % 2 == 0 else -1) % MOD
print(str(ans % MOD) + '\n')