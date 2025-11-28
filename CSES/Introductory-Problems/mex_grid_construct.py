import sys, io, os
input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
write = sys.stdout.write

n = int(input())

ans = [[-1 for _ in range(n)] for _ in range(n)]
for i in range(n):
	ans[i][i] = 0
	ans[0][i] = i
	ans[i][0] = i

for i in range(1, n):
	for j in range(1, n):
		if ans[i][j] != -1:
			continue
		skib = set()
		for k in range(i):
			skib.add(ans[k][j])
		for k in range(j):
			skib.add(ans[i][k])
		mex = 0
		while mex in skib:
			mex += 1
		ans[i][j] = mex

for a in ans:
	write(' '.join(map(str, a)) + '\n')