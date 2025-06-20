# impl start 11:31
for _ in range(int(input())):
	n = int(input())
	a = [*map(int, input().split())]
	b = [*map(int, input().split())]
	ops = []
	for _ in range(n):
		for i in range(n-1):
			if a[i] > a[i+1]:
				ops.append(f"1 {i+1}")
				a[i], a[i+1] = a[i+1], a[i]
			if b[i] > b[i+1]:
				ops.append(f"2 {i+1}")
				b[i], b[i+1] = b[i+1], b[i]
	for i in range(n):
		if a[i] > b[i]:
			ops.append(f"3 {i+1}")
			a[i], b[i] = b[i], a[i]
	print(len(ops))
	if ops != []: print('\n'.join(map(str, ops)))