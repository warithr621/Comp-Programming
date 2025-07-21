# https://codeforces.com/contest/1998/problem/B

for _ in range(int(input())):
    n = int(input())
    a = [*map(int, input().split())]
    if n == 1:
        print(a[0])
    else:
        print(' '.join(map(str, a[1:])), a[0])