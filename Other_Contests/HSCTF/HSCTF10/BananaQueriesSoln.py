# HSCTF10 algo/banana-queries

from pwn import *

io = remote("banana-queries.hsctf.com", 1337)

n = int(io.recvline())
a = [*map(int, io.recvline().split())]
p = [0]
for i in a: p.append(p[-1] + i)
ans = -1
for i in range(1, n+1):
	for j in range(0, i):
		if (p[i] - p[j]) % (i - j) == 0:
			ans = max(ans, i - j)

io.sendline(str(ans))
io.interactive()