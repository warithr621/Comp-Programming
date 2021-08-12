#Problem: https://codeforces.com/contest/1551/problem/A

for _ in range(int(input())):
    n = int(input())
    print(n // 3 + 1 if n % 3 == 1 else n // 3, n // 3 + 1 if n % 3 == 2 else n // 3)
