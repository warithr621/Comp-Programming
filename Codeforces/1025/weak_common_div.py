# https://codeforces.com/contest/1025/problem/B

import sys
from math import sqrt
read = sys.stdin.readline
write = sys.stdout.write


def factor(a, b):
	ret = set()
	i = 2
	while i <= sqrt(max(a, b)):
		while a % i == 0:
			ret.add(i)
			a //= i
		while b % i == 0:
			ret.add(i)
			b //= i
		i += 1

	if a >= 2:
		ret.add(a)
	if b >= 2:
		ret.add(b)
	return ret


def test(a, b, s):
	ret = set()
	for i in s:
		if a % i == 0 or b % i == 0:
			ret.add(i)
	return ret


n = int(read())
a = []
b = []
for _ in range(n):
	x,y = map(int, read().split())
	a.append(x); b.append(y);
	
f = factor(a[0], b[0])
# write(str(f) + '\n')
for i in range(1, n):
	f = test(a[i], b[i], f)

if len(f) == 0:
	write("-1\n")
else:
	for i in f:
		write(str(i) + '\n')
		break