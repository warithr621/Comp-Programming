def in_li(num=True):
    return [*map(int if num else str, input().split())]

def solve():
    #code
    n = int(input())
    a = in_li()
    a.sort()
    print(a[-1] - a[0])

t = int(input())
for quack in range(t):
    solve()