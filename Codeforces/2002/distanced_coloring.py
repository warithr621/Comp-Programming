# https://codeforces.com/contest/2002/problem/A

for _ in range(int(input())):
    n, m, k = map(int, input().split())
    print(min(n,k) * min(m,k))