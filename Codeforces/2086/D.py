import math
import sys
from collections import defaultdict
read = sys.stdin.readline
write = sys.stdout.write
MOD = 998244353

def in_li(num=True):
    return [*map(int if num else str, read().split())]

MAXN = 5 * 10**5
fact = [1] * (MAXN + 1)
inv_fact = [1] * (MAXN + 1)
for i in range(1, MAXN + 1):
    fact[i] = fact[i-1] * i % MOD

inv_fact[MAXN] = pow(fact[MAXN], MOD-2, MOD)
for i in range(MAXN-1, -1, -1):
    inv_fact[i] = inv_fact[i+1] * (i+1) % MOD

def ncr(n, k):
    if n < 0 or k < 0 or k > n:
        return 0
    return fact[n] * inv_fact[k] % MOD * inv_fact[n-k] % MOD

def solve():
    # code
    freq = in_li()
    L = sum(freq)
    epos, opos = (L + 1) // 2, L // 2
    multi, single = [], 0
    for i in range(26):
        if freq[i] > 1:
            multi.append(freq[i])
        elif freq[i] == 1:
            single += 1

    dp = defaultdict(int)
    dp[0] = 1
    for cnt in multi:
        ndp = defaultdict(int)
        for e, ways in dp.items():
            ne = e + cnt
            if ne <= epos:
                ndp[ne] = (ndp[ne] + ways) % MOD
            ne = e
            if ne <= epos:
                ndp[ne] = (ndp[ne] + ways) % MOD
        dp = ndp
    
    total = 0
    for e, ways in dp.items():
        o = sum(multi) - e
        if o > opos:
            continue
        remainingE, remainingO = epos - e, opos - o
        low = max(0, single - remainingO)
        high = min(single, remainingE)
        if low > high:
            continue
        combsum = 0
        for x in range(low, high + 1):
            combsum = (combsum + ncr(single, x)) % MOD
        total = (total + ways * combsum % MOD * fact[e + low] % MOD * fact[o + (single - low)] % MOD) % MOD
    
    denom = 1
    for cnt in multi:
        denom = denom * inv_fact[cnt] % MOD
    total = total * denom % MOD

    write(str(total) + '\n')

t = int(read())
for quack in range(t):
    solve()