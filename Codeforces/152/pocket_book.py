# https://codeforces.com/contest/152/problem/C

N, M = map(int, input().split())
A = []
for _ in range(N):
    A.append(input())
ans = 1
for i in range(M):
    tmp = set()
    for x in A:
        tmp.add(x[i])
    ans = ans * len(tmp) % int(1e9 + 7)
print(ans)