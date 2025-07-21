# https://codeforces.com/contest/1340/problem/A

import sys
read = sys.stdin.readline
write = sys.stdout.write

def recur(p, i):
    if i == len(p):
        print(p[1:])
        return 0
    n = len(p) - 1
    r = [0 for _ in range(n+1)]
    for j in range(1, n+1):
        ptr = j
        while ptr <= n and p[ptr] != 0:
            ptr += 1
        if ptr != n+1:
            r[j] = ptr
    cnt = [0 for _ in range(n+1)]
    for j in range(1, n+1):
        cnt[j] = r[1:].count(j);
    print("!", p[1:], r[1:], cnt[1:])
    for j in range(1, n+1):
        if cnt[j] == max(cnt[1:]) and p[j] == 0:
            nxt = p.copy()
            nxt[j] = i
            print("!", nxt)
            recur(nxt, i+1)

def helper():
    for n in range(1, 6):
        p = [0 for _ in range(n+1)]
        print(recur(p, 1))
        print("~")
        
# above code was to see all working examples for small N and look for patterns
for _ in range(int(read())):
    N = int(read())
    P = list(map(int, read().split()))
    pos = [0 for _ in range(N+1)]
    
    for i in range(N):
        pos[P[i]] = i
    works = True
    vis = [False for _ in range(N)]
    
    for i in range(1, N+1):
        if not works:
            break
        if vis[pos[i]]:
            continue
        p = pos[i]
        
        while p < N:
            vis[p] = True
            if p + 1 == N:
                break
            if vis[p + 1]:
                break
            if P[p + 1] == P[p] + 1:
                p += 1
            else:
                works = False
                break
                
    write("Yes\n" if works else "No\n")