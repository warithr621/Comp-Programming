fact = [1]
for i in range(1, 21):
	fact.append(fact[-1] * i)

for _ in range(int(input())):
	q = [*map(int, input().split())]
	if q[0] == 1:
		# given n and k, find kth permutation of [1..n]
		n, k = q[1], q[2] - 1
		ans = []
		nums = list(range(1, n+1))
		for i in range(n, 0, -1):
			f = fact[i-1]
			idx = k // f
			ans.append(nums.pop(idx))
			k %= f
		print(*ans)
	else:
		# given n and the permutation, find its index
		n = q[1]
		a = q[2:]
		k = 0
		for i in range(n):
			f = fact[n - i - 1]
			idx = a[i] - 1
			for j in range(i):
				if a[j] < a[i]:
					idx -= 1
			k += idx * f
		k += 1
		print(k)