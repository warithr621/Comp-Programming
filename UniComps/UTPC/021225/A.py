N = int(input())
A = []
for _ in range(N):
    A.append(input())
ans = ['.' for _ in range(len(A[0]))]
for i in range(len(A[0])):
    for S in A:
        if S[i] != '.':
            ans[i] = S[i]
print(''.join(map(str, ans)))