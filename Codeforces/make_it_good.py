#Problem: https://codeforces.com/contest/1385/problem/C
for _ in range(int(input())):
    n = int(input())
    L = list(map(int, input().split()))
    n -= 1
    while n > 0 and L[n-1] >= L[n]:
        n -= 1
    while n > 0 and L[n-1] <= L[n]:
        n -= 1
    print(n)
