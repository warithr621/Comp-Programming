# 10 min 38 sec

for _ in range(int(input())):
	n, m = map(int, input().split())
	a = []
	for i in range(n):
		a.append(input().strip())
	# all dominos are either LR or DU pairs
	works = True
	for i in range(n):
		if (a[i].count('U') + a[i].count('D')) % 2 == 1:
			works = False
			break
	for j in range(m):
		tmp = [a[i][j] for i in range(n)]
		if (tmp.count('L') + tmp.count('R')) % 2 == 1:
			works = False
			break
	if not works:
		print(-1)
		continue
	# must work from here I think
	grid = [['.' for _ in range(m)] for _ in range(n)]
	for i in range(n):
		balance = 0
		for j in range(m):
			if a[i][j] == 'U':
				grid[i][j] = ('W' if balance == 0 else 'B')
				grid[i+1][j] = ('B' if balance == 0 else 'W')
				balance ^= 1
	for j in range(m):
		balance = 0
		for i in range(n):
			if a[i][j] == 'L':
				grid[i][j] = ('W' if balance == 0 else 'B')
				grid[i][j+1] = ('B' if balance == 0 else 'W')
				balance ^= 1
	for arr in grid:
		print(''.join(arr))

