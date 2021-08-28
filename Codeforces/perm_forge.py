#Problem: https://codeforces.com/contest/1405/problem/B

for _ in range(int(input())):
    n = int(input())
    L = list(map(int, input().split()))
    ans = 0
    cur = 0
    for i in range(n-1, -1, -1):
        if (L[i] == 0):
            continue
        if L[i] > 0:
            L[0] += L[i]
            ans += L[i]
            L[i] = 0
        else:
            L[i-1] += L[i]
            L[i] = 0
    print(ans)
