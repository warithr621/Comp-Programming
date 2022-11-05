# https://codeforces.com/contest/1742/problem/E

from bisect import bisect_right as ub

for _ in range(int(input())):
    n,q = map(int, input().split())
    a = list(map(int, input().split()))
    pf = [0]
    pmx = []
    for i in range(n):
        pf.append(pf[i] + a[i])
        if i == 0:
            pmx.append(a[i])
        else:
            pmx.append(max(a[i], pmx[i-1]))
    
    
    queries = list(map(int, input().split()))
    for k in queries:
        idx = ub(pmx, k, 0, len(pmx))
        print(pf[idx], end=' ')
    print()