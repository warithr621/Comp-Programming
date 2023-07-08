# https://codeforces.com/contest/1364/problem/B
# 晴れ 晴れ

T = int(input())
for _ in range(T):
    N = int(input())
    A = list(map(int, input().split()))
    B = []
    for i in range(N):
        if i == 0 or i == N-1 or (A[i-1] < A[i]) != (A[i] < A[i+1]):
            B.append(A[i])
    print(len(B))
    print(' '.join(map(str, B)))