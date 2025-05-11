for _ in range(int(input())):
	N = int(input())
	A = [*map(int, input().split())]
	ans = 2001
	for i in range(N):
		cnt = 0
		for j in range(i+1, N):
			if A[j] > A[i]:
				cnt += 1
		ans = min(ans, i + cnt)
	print(ans)