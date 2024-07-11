# https://codeforces.com/contest/1992/problem/A

import sys
read = sys.stdin.readline

def solve():
    a = [*map(int, read().split())]
    for i in range(5):
        a.sort()
        a[0] += 1
    print(a[0] * a[1] * a[2])

t = int(read())
for _ in range(t):
    solve()