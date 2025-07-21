# https://codeforces.com/contest/1767/problem/B

for _ in range(int(input())):
    n, a = int(input()), list(map(int, input().split()))
    tmp = sorted(a[1:])
    for i in tmp:
        if i > a[0]:
            a[0] = (a[0] + i + 1) // 2
    print(a[0])