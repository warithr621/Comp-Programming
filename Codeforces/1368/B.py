K = int(input())
A = [1 for _ in range(10)]
prod = 1
idx = 0
while prod < K:
	prod = prod // A[idx] * (A[idx] + 1)
	A[idx] += 1
	idx = (idx + 1) % 10
S = "codeforces"
for i in range(10):
	print(S[i] * A[i], end='')