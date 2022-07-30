#Problem: https://codeforces.com/contest/1326/problem/A

for _ in range(int(input())):
    n = int(input())
    print("-1" if n == 1 else "2" + "3" * (n-1))
