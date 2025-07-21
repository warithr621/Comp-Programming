# https://codeforces.com/contest/166/problem/C

n, x = map(int, input().split())
a = sorted([*map(int, input().split())])
ans = 0
while a[(len(a) - 1) // 2] != x:
    ans += 1
    a.append(x)
    a.sort()
print(ans)