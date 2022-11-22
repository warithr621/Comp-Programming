# https://codeforces.com/contest/1407/problem/C

import sys
read = sys.stdin.readline
write = sys.stdout.write
flush = sys.stdout.flush

def query(x, y):
	write("? " + str(x+1) + " " + str(y+1) + '\n')
	flush()
	return int(read())

n = int(read())
ans = []
for _ in range(n): ans.append(-1);
mx = 0

for i in range(1,n):
	a = query(mx, i)
	b = query(i, mx)
	if a > b:
		ans[mx] = a
		mx = i
	else:
		ans[i] = b
ans[mx] = n


write("! ")
for num in ans:
	write(str(num) + " ")

write('\n')
flush()