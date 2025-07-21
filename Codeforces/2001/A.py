# https://codeforces.com/contest/2001/problem/A

from collections import Counter

for _ in range(int(input())):
    n = int(input())
    c = Counter([*map(int, input().split())])
    print(n - max(list(c.values())))