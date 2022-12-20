# https://codeforces.com/contest/1762/problem/A

for _ in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))
    s = sum(a)
    if s % 2 == 0:
        print(0)
    else:
        ans = 1e9
        for x in a:
            par = x % 2
            cur = 0
            while x % 2 == par:
                cur += 1
                x >>= 1
            ans = min(ans, cur)
        print(ans)