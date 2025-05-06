for _ in range(int(input())):
    n, m = map(int, input().split())
    ans = 0
    for i in range(31):
        x = n & ((1 << (i+1)) - 1)
        t = (1 << i) - x
        if n >= (1 << i):
            t = min(t, x + 1)
        if x >= (1 << i) or t <= m:
            ans |= (1 << i)
    print(ans)