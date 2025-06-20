for _ in range(int(input())):
	n = int(input())
	a = [1] + [x for x in range(3, n+1)] + [2]
	print(' '.join(map(str, a)))