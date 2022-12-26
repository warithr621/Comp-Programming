# 2022 Dec Bronze P1

N = int(input())
A = sorted(list(map(int, input().split())))
amt, best = 0, 0

for i in range(N):
	test = A[i] * (N-i)
	if test > amt:
		amt, best = test, A[i]

print(amt, best)