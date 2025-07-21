# https://codeforces.com/contest/1998/problem/A

for _ in range(int(input())):
    x, y, k = map(int, input().split())
    for v in range(-(k//2), (k//2)+1):
        if k % 2 == 0 and v == 0:
            continue
        print(x+v, y)