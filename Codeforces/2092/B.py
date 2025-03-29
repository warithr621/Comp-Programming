def solve():
    #code
    n = int(input())
    a, b = input(), input()
    # split this into two parts, one should have (n+1)//2, and other n - that
    r1 = (n+1)//2
    r2 = n - r1
    xcnt, ycnt = 0, 0
    for i in range(n):
        if i % 2 == 0:
            xcnt += (1 if a[i] == '0' else 0)
            ycnt += (1 if b[i] == '0' else 0)
        else:
            ycnt += (1 if a[i] == '0' else 0)
            xcnt += (1 if b[i] == '0' else 0)
    print("YES" if xcnt >= r1 and ycnt >= r2 else "NO")

t = 1
t = int(input())
for quack in range(t):
    solve()