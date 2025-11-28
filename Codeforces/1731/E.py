import sys, io, os
input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
write = sys.stdout.write
MAXN = int(1e6)

phi = [0] * (MAXN+1)
primes = []
phi[1] = 1
is_composite = [False] * (MAXN + 1)
for i in range(2, MAXN+1):
	if not is_composite[i]:
		primes.append(i)
		phi[i] = i - 1
	for p in primes:
		if i * p > MAXN:
			break
		is_composite[i * p] = True
		if i % p == 0:
			phi[i * p] = phi[i] * p
			break
		else:
			phi[i * p] = phi[i] * (p - 1)
pref = [0] * (MAXN+1)
for i in range(1, MAXN+1):
	pref[i] = pref[i-1] + phi[i]

for _ in range(int(input())):
	n, m = map(int, input().split())
	# find no. of pairs (x,y) s.t. gcd(x,y) = i for all i
	gcd = [0] * (n+1)
	for i in range(1, n+1):
		skibidi = n // i
		if skibidi < 2:
			gcd[i] = 0
		else:
			gcd[i] = pref[skibidi] - 1
	# for a given k, we can build k-1 edges of weight k for cost k
	ans, k = 0, n
	while k > 1 and m > 0:
		build = min(m, gcd[k])
		ans += build // (k-1) * k
		m -= build // (k-1) * (k-1)
		gcd[k] -= build // (k-1) * (k-1)
		k -= 1
	write((str(ans) if m == 0 else "-1") + '\n')
	# print('-' * 10)