import sys, io, os
input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
write = sys.stdout.write
MOD = int(1e9+7)

def solve():
	#code
	n, m = map(int, input().split())
	d, i = n, 2
	while i * i <= n:
		if n % i == 0:
			d = i
			break
		i += 1
	write('yes\n' if d > m or n == 1 else 'no\n')

t = int(input())
for quack in range(t):
	solve()
