for _ in range(int(input())):
	N = int(input())
	A = [*map(int, input().split())]
	S = set()
	for i in range(N):
		if A[i] - 1 != i:
			S.add(i)
	if len(S) == 0:
		print(0)
	else:
		S = sorted(list(S))
		if S[0] + len(S) - 1 == S[-1]:
			print(1)
		else:
			print(2)