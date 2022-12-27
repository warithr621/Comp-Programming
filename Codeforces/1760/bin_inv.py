# https://codeforces.com/contest/1760/problem/E

for _ in range(int(input())):
	N, A = int(input()), list(map(int, input().split()))
	ans, ones = 0, 0;
	for i in range(N):
		if A[i] == 1:
			ones += 1
		else:
			ans += ones

	new = 0
	old = ones
	for i in range(N):
		if A[i] == 0:
			new = max(new, N - 1 - i - old)
		else:
			ones -= 1
			new = max(new, old + i - N)
			
	print(ans + new)