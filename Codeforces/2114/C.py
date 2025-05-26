def in_li(num=True):
    return [*map(int if num else str, input().split())]

def solve():
    #code
    n = int(input())
    a = in_li()
    ans, i = 0, 0
    while i < n:
        ans += 1
        cur = a[i]
        while i < n and a[i] <= cur + 1:
            i += 1
    print(ans)

t = 1
t = int(input())
for quack in range(t):
    solve()