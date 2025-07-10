# below sol is very overdone, simpler idea can be found here
# https://codeforces.com/contest/1151/submission/328300193 <-- hastorius orz

n, m = map(int, input().split())
a = []
for _ in range(n):
	a.append([*map(int, input().split())])

# bounds should make this rly easy
# just see for each bit how many 1-only, 0-only, and both
for bit in range(10):
	tz, to, tb = [], [], []
	for i in range(n):
		z, o = -1, -1
		for j in range(m):
			if (a[i][j] >> bit) & 1:
				o = j+1
			else:
				z = j+1
		if z == -1:
			to.append((i, o))
		elif o == -1:
			tz.append((i, z))
		else:
			tb.append((i, o, 1))
			tb.append((i, z, 0))
	if len(to) % 2 == 1 or len(tb) != 0:
		print("TAK")
		ans = []
		found = [-1 for _ in range(n)]
		for i, j in to:
			found[i] = j
		if len(to) % 2 == 0:
			for i, j, v in tb:
				if found[i] == -1 and v == 1:
					found[i] = j
					break
		for i, j in tz:
			if found[i] == -1:
				found[i] = j
		for i, j, v in tb:
			if found[i] == -1 and v == 0:
				found[i] = j
		print(*found)
		exit()
print("NIE")