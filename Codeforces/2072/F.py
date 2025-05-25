for _ in range(int(input())):
	N, K = map(int, input().split())
	# ok lucas' theorem time
	for i in range(N):
		if (i & (N - 1 - i)) == 0:
			print(K, end=' ')
		else:
			print(0, end=' ')
	print()