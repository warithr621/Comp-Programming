# 2019 NAQ: Missing Numbers

N = int(input())
A = []
for _ in range(N):
    A.append(int(input()))
M = A[-1]
X = [False for _ in range(M+1)]
for I in A:
    X[I] = True
if len(A) == M:
    print("good job")
    exit(0)
for I in range(1, M+1):
    if not X[I]:
        print(I)