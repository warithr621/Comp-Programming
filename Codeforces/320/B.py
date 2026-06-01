n = int(input())
intervals = []
reach = []
for _ in range(n):
	type, x, y = map(int, input().split())
	if type == 1:
		m = len(intervals)
		intervals.append((x, y))
		for row in reach:
			row.append(False)
		reach.append([False] * (m + 1))
		for i in range(m + 1):
			reach[i][i] = True
		for i in range(m):
			a, b = intervals[i]
			if a < x < b or a < y < b:
				reach[m][i] = True
			if x < a < y or x < b < y:
				reach[i][m] = True
		for k in range(m + 1): # holy n^3
			for i in range(m + 1):
				if reach[i][k]:
					for j in range(m + 1):
						if reach[k][j]:
							reach[i][j] = True
	else:
		print("YES" if reach[x-1][y-1] else "NO")
