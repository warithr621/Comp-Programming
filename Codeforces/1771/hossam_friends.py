# https://codeforces.com/problemset/problem/1771/B

T = int(input())
for i in range(T):
    N, M = map(int, input().split())
    mnfx = [0] # "mn prefix"
    for i in range(N):
        mnfx.append(N)
        
    for i in range(M):
        X, Y = map(int, input().split())
        if X > Y:
            X, Y = Y, X
        
        mnfx[X] = min(mnfx[X], Y-1)
        
    for i in range(N-1, -1, -1):
        mnfx[i] = min(mnfx[i], mnfx[i+1])
    
    ans = N
    for i in range(N):
        ans += mnfx[i] - i
        
    print(ans)