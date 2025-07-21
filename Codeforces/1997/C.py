# https://codeforces.com/contest/1997/problem/C

import sys
import math
read = sys.stdin.readline
write = sys.stdout.write
MOD = int(1e9+7)

def solve():
    #code
    N = int(read())
    S = list(read())
    cost = 0
    pfx = 0
    for i in range(N):
        c = S[i]
        if c == '_':
            if i == 0 or pfx <= 0:
                # S[i] = '('
                pfx += 1
                cost -= i
            else:
                # S[i] = ')'
                pfx -= 1
                cost += i
        else:
            if c == '(':
                pfx += 1
                cost -= i
            else:
                pfx -= 1
                cost += i
    write(str(cost) + '\n')


t = int(read())
for quack in range(t):
    solve()