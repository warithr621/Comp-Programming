def solve():
    # code
    n, m = map(int, input().split())
    a = input().split()
    found = set()
    mx = 0
    for _ in range(m):
        b = input().split()
        cnt = 0
        for i in range(n):
            if a[i] == b[i]:
                cnt += 1
                found.add(i)
        mx = max(mx, cnt)
    print(-1 if len(found) != n else n + 2 * (n - mx))

t = int(input())
for quack in range(t):
    solve()