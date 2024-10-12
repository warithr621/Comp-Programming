
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

def solve():
    #code
    n, t = map(int, input().split())
    a = sorted(in_li())
    cnt = 0
    i = 0
    while i < n:
        if t - a[i] < 0:
            break
        t -= a[i]
        i += 1
        cnt += 1
    write(str(cnt) + '\n')

t = 1
# t = int(read())
for quack in range(t):
    solve()
