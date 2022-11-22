# https://codeforces.com/contest/1761/problem/A

for _ in range(int(input())):
    n,a,b = map(int, input().split())
    if a == n and b == n or a + b + 1 < n:
        print("YES")
    else:
        print("NO")