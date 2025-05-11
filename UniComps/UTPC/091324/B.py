def solve(S, N, K):
    L = 0
    cnt = 0
    ans = 0
    
    for R in range(N):
        if S[R] == '2':
            cnt += 1
        
        while cnt > K:
            if S[L] == '2':
                cnt -= 1
            L += 1
        
        ans = max(ans, R-L+1)
    
    return ans

N, K = map(int, input().split())
S = input()
print(solve(S,N,K))