for _ in range(int(input())):
	n = int(input())
	a = [*map(int, input().split())]
	b = [*map(int, input().split())]
	works = True
	for i in range(n):
		works &= (a[i] == b[i] or (i != n-1 and (a[i] ^ a[i+1] == b[i] or a[i] ^ b[i+1] == b[i])))
	print('yes' if works else 'no')