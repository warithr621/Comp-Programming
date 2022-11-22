# https://codeforces.com/problemset/problem/1359/C

from sys import stdin, stdout

def solve():
	h, c, t = map(int, stdin.readline().split())
	if h + c >= 2 * t:
		stdout.write("2\n")
		return
	a = h - t
	b = 2 * t - c - h
	k = 2 * (a // b) + 1

	v1 = abs(k // 2 * c + (k+1) // 2 * h - t * k)
	v2 = abs((k + 2) // 2 * c + (k + 3) // 2 * h - t * (k+2))

	if v1 * (k+2) <= v2 * k:
		stdout.write(str(k))
	else:
		stdout.write(str(k+2))
	stdout.write('\n')

for _ in range(int(stdin.readline())):
	solve()