
# Im Nayeon
# Yoo Jeongyeon
# Momo Jjang
# Sana Jjang
# Park Jihyo
# Mina Jjang
# Kim Dahyun
# Son Chaeyoung
# Chou Tzuyu
# One in a million
# 눈부시게 사랑해
# 트와이스 !!

import sys
import math
read = sys.stdin.readline
write = sys.stdout.write
MOD = int(1e9+7)

def fexp(x, n):
    x %= MOD
    if x == 0:
        return (1 if n == 0 else 0)
    if x == 1 or n == 0:
        return 1
    if n == 1:
        return x

    ans = 1
    while n > 0:
        if (n & 1) == 1:
            ans = ans * x % MOD
        x = x * x % MOD
        n >>= 1
    return ans

def inp():
    return read()

def in_li(num=True):
    return [*map(int if num else str, read().split())]

def solver(a):
    L, R = 0, len(a) - 1
    LM, RM = a[L], a[R]
    pools = []
    curh, curv = 0, 0
    while L < R:
        if LM < RM:
            L += 1
            LM = max(LM, a[L])
            if LM > a[L]:
                if curh == 0:
                    curh = LM
                curv += LM - a[L]
            else:
                if curh > 0:
                    pools.append([curh, curv])
                    curh, curv = 0, 0
        else:
            R -= 1
            RM = max(RM, a[R])
            if RM > a[R]:
                if curh == 0:
                    curh = RM
                curv += RM - a[R]
            else:
                if curh > 0:
                    pools.append([curh, curv])
                    curh, curv = 0, 0

    if curh > 0:
        pools.append([curh, curv])
    return pools

def solve():
    #code
    n = int(inp())
    a = in_li()
    pools = solver(a)
    # print(pools)
    mxh = 0
    for p in pools:
        mxh = max(mxh, p[0])
    ans = 0
    for p in pools:
        ans += (0 if p[0] != mxh else p[1])
    write(str(ans) + '\n')

t = 1
# t = int(read())
for quack in range(t):
    solve()
