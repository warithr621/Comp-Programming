MOD = 998244353

for _ in range(int(input())):
	n = int(input())
	p = [*map(int, input().split())]
	q = [*map(int, input().split())]
	# r[i] = max(2^pj + 2^q{i-j}) for all i
	# recall p and q are permutations
	r = [(pow(2, p[0], MOD) + pow(2, q[0], MOD)) % MOD]
	mp, mq = 0, 0
	for i in range(1, n):
		if p[i] > p[mp]:
			mp = i
		if q[i] > q[mq]:
			mq = i
		if p[mp] > q[mq] or (p[mp] == q[mq] and q[i-mp] > p[i-mq]):
			r.append((pow(2, p[mp], MOD) + pow(2, q[i - mp], MOD)) % MOD)
		else:
			r.append((pow(2, p[i - mq], MOD) + pow(2, q[mq], MOD)) % MOD)
	print(*r)