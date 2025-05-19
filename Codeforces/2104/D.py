# sieve
primes = []
sieve = [True for _ in range(5800085)]
for p in range(2, 5800085):
	if sieve[p]:
		primes.append(p)
		for q in range(p * p, 5800085, p):
			sieve[q] = False

for _ in range(int(input())):
	N = int(input())
	A = [*map(int, input().split())]
	A.sort(reverse=True)
	ans = 0
	runA, runP = 0, 0
	for i in range(N):
		# check if the sum of the first `i` elements of A is at least the sum of the first `i` primes
		runA += A[i]
		runP += primes[i]
		if runA >= runP:
			ans += 1
		else:
			break
	print(N - ans)