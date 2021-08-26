#Problem: https://codeforces.com/contest/1562/problem/A

for _ in range(int(input())):
    L,R = map(int, input().split())
    print(R - L if L > R//2 + 1 else (R-1) // 2)
