for _ in range(int(input())):
	n = int(input())
	v = 2
	while (v+1) * v // 2 <= n:
		v += 1
	q = n - v * (v-1) // 2
	print('133', '7' * q, '3' * (v-2), '7', sep='')