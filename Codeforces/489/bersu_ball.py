# https://codeforces.com/problemset/problem/489/B

N = int(input())
A = sorted(list(map(int, input().split())))
M = int(input())
B = sorted(list(map(int, input().split())))

ans = 0
for i in range(N):
    for j in range(M):
        if abs(A[i] - B[j]) <= 1:
            B[j] = float('inf') # lol
            ans += 1
            break
        
print(ans)