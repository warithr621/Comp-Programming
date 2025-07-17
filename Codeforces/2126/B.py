def in_li(num=True):
    return [*map(int if num else str, input().split())]

def solve():
    #code
    n, k = map(int, input().split())
    a = in_li()
    p = [0] * (n+1)
    for i in range(1, n+1):
        p[i] = p[i-1] + a[i-1]
    ans, i = 0, 1
    while i + k - 1 <= n:
        if p[i+k-1] - p[i-1] == 0:
            ans += 1
            i += k+1
        else:
            i += 1
    print(ans)

t = int(input())
for quack in range(t):
    solve()
