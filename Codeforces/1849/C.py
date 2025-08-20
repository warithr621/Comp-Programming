# wow i love abusing hashing

MOD1, MOD2 = int(1e9+7), int(1e9+9)
B1, B2 = 91138233, 97266353

def hash_pcomp(s):
	n = len(s)
	h1, h2, p1, p2 = [0] * (n+1), [0] * (n+1), [1] * (n+1), [1] * (n+1)
	for i, ch in enumerate(s, start=1):
		c = ord(ch)
		h1[i] = (h1[i-1] * B1 + c) % MOD1
		h2[i] = (h2[i-1] * B2 + c) % MOD2
		p1[i] = (p1[i-1] * B1) % MOD1
		p2[i] = (p2[i-1] * B2) % MOD2
	return h1, h2, p1, p2

def run(n):
	r01, r02, r11, r12 = [0] * (n+1), [0] * (n+1), [0] * (n+1), [0] * (n+1)
	for k in range(1, n+1):
		r01[k] = (r01[k-1] * B1 + 48) % MOD1
		r02[k] = (r02[k-1] * B2 + 48) % MOD2
		r11[k] = (r11[k-1] * B1 + 49) % MOD1
		r12[k] = (r12[k-1] * B2 + 49) % MOD2
	return r01, r02, r11, r12

def subhash(h, p, l, r, MOD):
	return (h[r] - h[l-1] * p[r-l+1] % MOD + MOD) % MOD

for _ in range(int(input())):
	n, m = map(int, input().split())
	s = input().strip()
	q = []
	for i in range(m):
		l, r = map(int, input().split())
		q.append((l,r))
	ones = [0] * (n+1)
	for i, c in enumerate(s, start=1):
		ones[i] = ones[i-1] + (c == '1')

	h1, h2, p1, p2 = hash_pcomp(s)
	r01, r02, r11, r12 = run(n)

	vis = set()
	for l, r in q:
		o = ones[r] - ones[l-1]
		length = r-l+1
		z = length-o
		ha1 = subhash(h1, p1, 1, l-1, MOD1) if l > 1 else 0
		hb1 = r01[z]
		hc1 = r11[o]
		hd1 = subhash(h1, p1, r+1, n, MOD1) if r < n else 0
		p11 = (ha1 * p1[z+o] + hb1 * p1[o] + hc1) % MOD1
		sussy = (p11 * p1[n-r] + hd1) % MOD1

		ha1 = subhash(h2, p2, 1, l-1, MOD2) if l > 1 else 0
		hb1 = r02[z]
		hc1 = r12[o]
		hd1 = subhash(h2, p2, r+1, n, MOD2) if r < n else 0
		p12 = (ha1 * p2[z+o] + hb1 * p2[o] + hc1) % MOD2
		sussier = (p12 * p2[n-r] + hd1) % MOD2

		vis.add((sussy, sussier))

	print(len(vis))
