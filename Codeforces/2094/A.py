# contest too hard

for _ in range(int(input())):
	a = [*map(str, input().split())]
	a = [x[0] for x in a]
	print(''.join(map(str, a)))