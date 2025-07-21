#Problem: https://codeforces.com/contest/1227/problem/A

t = int(input())
for _ in range(t):
    n = int(input())
    L = 0
    R = 1000000001
    for i in range(n):
        a, b = map(int,input().split())
        R = min(R, b)
        L = max(L, a)
    print(max(0,L - R))

