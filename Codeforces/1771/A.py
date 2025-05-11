# https://codeforces.com/contest/1771/problem/A

for _ in range(int(input())):
	N, A = int(input()), sorted(list(map(int, input().split())))
	if A[-1] == A[0]:
		print(N * (N-1))
	else:
		print(A.count(A[0]) * A.count(A[-1]) * 2)