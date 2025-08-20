def kadane(arr):
    mx = -float('inf')
    cur, start, l, r = 0, 0, 0, -1
    for i, x in enumerate(arr):
        if cur + x < x:
            cur = x
            start = i
        else:
            cur += x
        if cur > mx:
            mx = cur
            l, r = start, i
    return mx, l, r

for _ in range(int(input())):
    n = int(input())
    a = [*map(int, input().split())]
    b = [-x for x in a]
    _, l, _ = kadane(b)
    ans = 0
    for i in range(l):
        ans += a[i]
    print(ans)