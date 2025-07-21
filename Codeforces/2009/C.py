# https://codeforces.com/contest/2009/problem/C

for _ in range(int(input())):
    x, y, k = map(int, input().split())
    x, y = (x + k - 1) // k, (y + k - 1) // k
    if x == y:
        print(2 * x)
    elif x > y:
        print(2 * x - 1)
    else:
        print(2 * y)