#Problem: https://codeforces.com/contest/1405/problem/A
for _ in range(int(input())):
    n = int(input())
    L = list(map(int, input().split()))
    for i in range(n-1,-1,-1):
        print(L[i], end=' ')
    print()
