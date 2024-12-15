# https://codeforces.com/contest/2047/problem/B


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
    return read().strip()

def in_li(num=True):
    return [*map(int if num else str, read().split())]

def fact(n):
	if n <= 1:
		return 1
	return n * fact(n-1)

def countperms(s):
	ans = fact(len(s))
	for c in "qwertyuiopasdfghjklzxcvbnm":
		ans //= fact(s.count(c))
	return ans


def solve():
    #code
    n = int(inp())
    s = inp()
    best, perms = s, 10000000
    for i in range(n):
    	for j in range(n):
    		# set s[i] equal to s[j]
    		tmp = s[:i] + s[j] + s[i+1:]
    		c = countperms(tmp)
    		# print(tmp, c)
    		if c < perms:
    			best, perms = tmp, c
    print(best)

t = 1
t = int(read())
for quack in range(t):
    solve()
