# https://codeforces.com/contest/1660/problem/E

import sys
read = sys.stdin.readline
write = sys.stdout.write

def solve():
	read()
	n = int(read())
	a = []
	for _ in range(n): a.append(read());
	tot = 0
	for i in range(n):
		for j in range(n):
			tot += ord(a[i][j]) - ord('0')
	ans = 1000000000000000000
	#start at a[0][j] and traverse the diagonal
	for j in range(n):
		cur = 0
		curi = 0
		curj = j
		while curi != n:
			cur += ord(a[curi][curj]) - ord('0')
			curi += 1
			curj = (curj + 1) % n
		req = n - cur + tot - cur
		ans = min(ans, req)
	#start at a[i][0] and traverse the diagonal
	for i in range(n):
		cur = 0
		curi = i
		curj = 0
		while curj != n:
			cur += ord(a[curi][curj]) - ord('0')
			curj += 1
			curi = (curi + 1) % n
		req = n - cur + tot - cur
		ans = min(ans, req)
	print(str(ans))

for _ in range(int(read())): solve();