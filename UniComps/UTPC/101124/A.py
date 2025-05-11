
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
    x, n, ans = int(inp()), 1, 1
    for i in range(1, x):
        n = ((4 * n) ^ i) % 6
        # print(n)
        if n == 1:
            ans += 1
    write(str(ans) + '\n')

t = 1
# t = int(read())
for quack in range(t):
    solve()
