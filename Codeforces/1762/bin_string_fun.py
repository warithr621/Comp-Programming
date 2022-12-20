# https://codeforces.com/contest/1762/problem/C

import sys
read = sys.stdin.readline
write = sys.stdout.write

MOD = 998244353

def plus(a, b):
    return (a%MOD + b%MOD) % MOD

for _ in range(int(read())):
    n = int(read())
    s = read()
    ans, tmp = 1, 1
    for i in range(1, n):
        if s[i-1] == s[i]:
            tmp = (tmp << 1) % MOD
        else:
            tmp = 1

        ans = plus(ans, tmp)

    write(str(ans) + '\n')