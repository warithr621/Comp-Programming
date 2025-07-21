# https://codeforces.com/contest/1767/problem/A

for _ in range(int(input())):
    input()
    x = set()
    y = set()
    for i in range(3):
        a, b = map(int, input().split())
        x.add(a)
        y.add(b)
    print("NO" if len(x) == 2 and len(y) == 2 else "YES")