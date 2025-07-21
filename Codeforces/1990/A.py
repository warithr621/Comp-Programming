# https://codeforces.com/contest/1990/problem/A

for _ in range(int(input())):
    n = int(input())
    a = [*map(int, input().split())]
    c = [0 for _ in range(51)]
    for x in a:
        c[x] ^= 7
    w = False
    for x in c:
        if x != 0:
            w = True
    print("YES" if w else "NO")