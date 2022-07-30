#Problem: https://codeforces.com/contest/557/problem/A

n = int(input())
an, ax = map(int, input().split())
bn, bx = map(int, input().split())
cn, cx = map(int, input().split())

a = min(n, min(ax, n - bn - cn))
n -= a
b = min(n, min(bx, n - cn))
print(a, b, n-b, sep=' ')
