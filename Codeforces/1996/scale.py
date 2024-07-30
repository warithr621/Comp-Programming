# https://codeforces.com/contest/1996/problem/B

for _ in range(int(input())):
    n, k = map(int, input().split())
    a = []
    for i in range(n):
        a.append(input())
    ans = [[0 for q in range(n//k)] for q in range(n//k)]
    for i in range(0, n, k):
        for j in range(0, n, k):
            ans[i//k][j//k] = a[i][j]
    for x in ans:
        print(''.join(map(str, x)))