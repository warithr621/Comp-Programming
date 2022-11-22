# https://codeforces.com/contest/1249/problem/C1

import sys
read = sys.stdin.readline
write = sys.stdout.write

def three(x):
	exp = 0
	val = 1
	while val * 3 <= x:
		val *= 3
		exp += 1
	while exp >= 0:
		pw = 3**exp
		if x >= pw:
			x -= pw
		exp -= 1
	return x == 0

for _ in range(int(read())):
	n = int(read())
	while True:
		if three(n):
			write(str(n) + "\n")
			break
		n += 1