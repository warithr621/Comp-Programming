# https://codeforces.com/contest/1742/problem/B

for _ in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))
    a.sort()
    b = True
    for i in range(1, n):
        b &= a[i] > a[i-1]
    print("YES" if b else "NO")