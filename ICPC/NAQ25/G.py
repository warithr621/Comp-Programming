MOD = 998244353
n, k = map(int, input().split())

a = pow((2*k) % MOD, 2*k, MOD)
b = pow(pow((2*k+1) % MOD, 2*k, MOD), MOD - 2, MOD)
ans = (n % MOD) * a % MOD * b % MOD
print(ans)
