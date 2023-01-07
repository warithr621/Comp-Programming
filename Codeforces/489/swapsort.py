# https://codeforces.com/problemset/problem/489/A

N = int(input())
A = list(map(int, input().split()))

swaps = []
for i in range(N):
    mn = i
    for j in range(i, N):
        if A[j] < A[mn]:
            mn = j
    if i != mn:
        swaps.append([i, mn])
    A[i], A[mn] = A[mn], A[i]
    
print(len(swaps))
for x in swaps:
    print(x[0], x[1])