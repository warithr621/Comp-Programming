from collections import Counter, defaultdict

def factor(n):
	d = defaultdict(int)
	while n % 2 == 0:
		d[2] += 1
		n //= 2
	p = 3
	while p * p <= n:
		while n % p == 0:
			d[p] += 1
			n //= p
		p += 2
	if n > 1:
		d[n] += 1
	return d

def tidy(factors, K):
	a = []
	for p, e in factors.items():
		if e%K:
			a.append((p, e%K))
	return tuple(sorted(a))

def complement(f, K):
	comp = []
	for p, e in f:
		needed = (K - e) % K
		if needed:
			comp.append((p, needed))
	return tuple(sorted(comp))

N, K = map(int, input().split())
A = [*map(int, input().split())]
cnt = Counter()
ans = 0
for x in A:
	s = tidy(factor(x), K)
	ans += cnt[complement(s, K)]
	cnt[s] += 1
print(ans)