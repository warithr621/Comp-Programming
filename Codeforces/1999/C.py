# https://codeforces.com/contest/1999/problem/C

for _ in range(int(input())):
    n, s, m = map(int, input().split())
    iv = []
    for i in range(n):
        iv.append([*map(int, input().split())])
    w = False
    for i in range(n-1):
        w |= (iv[i+1][0] - iv[i][1] >= s)
    w |= (iv[0][0] - 0 >= s)
    w |= (m - iv[n-1][1] >= s)
    print("YES" if w else "NO")