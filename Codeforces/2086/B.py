import math
MOD = int(1e9+7)

def in_li(num=True):
    return [*map(int if num else str, input().split())]

def solve():
    #code
    n, k, x = map(int, input().split())
    a = in_li()
    S = sum(a)
    if k * S < x:
        print(0)
        return

    cnt = 0
    p = [0] * (n+1)
    for i in range(1, n+1):
        p[i] = p[i-1] + a[i-1]
    cnt = 0
    for idx in range(n):
        val = k * S - x - p[idx]
        if val >= 0:
            mn = min(val // S, k - 1)
            if mn >= 0:
                cnt += mn + 1
    print(cnt)

t = int(input())
for quack in range(t):
    solve()