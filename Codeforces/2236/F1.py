MOD = int(1e9+7)
MAX = 500000

spf = list(range(MAX + 1))
for i in range(2, int(MAX**0.5) + 1):
	if spf[i] == i:
		for j in range(i * i, MAX + 1, i):
			if spf[j] == j:
				spf[j] = i

def solve():
	#code
	n, x = map(int, input().split())
	a = [* map(int, input().split())]
	# for each ai, we pick pi s.t. pi | ai
	# find the number of arrays p s.t. lcm(elements in p) = prod(elements in p)
	# if lcm = prod, then all elements in p are pairwise coprime
	# equivalently, each prime only appears in one element of p
	skibidi = {}
	for val in a:
		while val > 1:
			p = spf[val]
			cnt = 0
			while val % p == 0:
				val //= p
				cnt += 1
			skibidi[p] = skibidi.get(p, 0) + cnt
	ans = 1
	# print(skibidi)
	for heh in skibidi.values():
		ans = ans * (1 + heh) % MOD
	print(ans)

t = int(input())
for quack in range(t):
	solve()
