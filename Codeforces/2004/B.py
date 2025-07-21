# https://codeforces.com/contest/2004/problem/B

for _ in range(int(input())):
    a, b = map(int, input().split())
    c, d = map(int, input().split())
    b, d = b+1, d+1
    if b <= c or d <= a:
        print(1)
    else:
        if a > c:
            a, c = c, a
        if b > d:
            b, d = d, b
        print(min(b, d-1) - max(a+1, c) + 1)