for _ in range(int(input())):
	n, k = map(int, input().split())
	a = [*map(int, input().split())]
	b = [*map(int, input().split())]
	a = [min(x%k, (k-x%k)%k) for x in a]
	b = [min(x%k, (k-x%k)%k) for x in b]
	print('yes' if sorted(a) == sorted(b) else 'no')