# https://codeforces.com/contest/1299/problem/A

import sys
from math import sqrt
read = sys.stdin.readline
write = sys.stdout.write


n = int(read())
a = list(map(int, read().split()))

pfx = []
sfx = []
for i in range(n):
	pfx.append((1<<31)-1)
	sfx.append((1<<31)-1)

for i in range(1, n):
	pfx[i] = pfx[i-1] & (~a[i-1])
for i in range(n-2, -1, -1):
	sfx[i] = sfx[i+1] & (~a[i+1])

mx = -1
pos = -1
for i in range(n):
	tmp = pfx[i] & a[i] & sfx[i]
	if tmp > mx:
		mx = tmp
		pos = i
	write(str(mx) + '\n')

write(str(a[pos]))
for i in range(n):
	if i != pos: write(' ' + str(a[i]))
write('\n')

# write(str(pfx))
# write('\n')
# write(str(sfx))