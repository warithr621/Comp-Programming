import math

def in_li(num=True):
    return [*map(int if num else str, input().split())]

def solve():
    #code
    n = int(input())
    p = in_li()
    s = in_li()
    # from p and s, we know a[0] = p[0] and a[-1] = s[-1]
    a = [x * y // math.gcd(x, y) for x, y in zip(p, s)]
    g = a[0]
    for i in range(n):
        g = math.gcd(g, a[i])
        if p[i] != g:
            print("NO")
            return
    g = a[-1]
    for i in range(n-1, -1, -1):
        g = math.gcd(g, a[i])
        if s[i] != g:
            print("no")
            return
    print("YES")

t = int(input())
for quack in range(t):
    solve()
