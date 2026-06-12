import sys
from collections import Counter
read = sys.stdin.readline
write = sys.stdout.write

n = int(read())
p = [*map(int, read().split())]
q = [*map(int, read().split())]
m = int(read())

nums = Counter(p)
nums.update(q)
dup = sum(1 for i in range(n) if p[i] == q[i])

n <<= 1
fact, pw = [1] * (n+1), [0] * (n+1)
for i in range(2, n+1):
	skib = (i & -i).bit_length() - 1
	odd = i >> skib
	fact[i] = fact[i-1] * odd % m
	pw[i] = pw[i-1] + skib

res, exp = 1, -dup
for v in nums.values():
	res = res * fact[v] % m
	exp += pw[v]
write(str(res * pow(2, exp, m) % m) + '\n')