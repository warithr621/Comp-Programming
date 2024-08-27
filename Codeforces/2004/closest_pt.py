# https://codeforces.com/contest/2004/problem/A

for _ in range(int(input())):
    n = int(input())
    a = [*map(int, input().split())]
    print("YES" if n == 2 and a[0] + 1 != a[1] else "NO")