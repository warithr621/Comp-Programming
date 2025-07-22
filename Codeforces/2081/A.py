MOD = int(1e9 + 7)
inv2 = int(5e8 + 4)

for _ in range(int(input())):
	n = int(input())
	s = input()
	# each operation, we're essentially chopping off the last digit,
	# so we only use either n-1 or n operations
	ans = 0
	for i in range(n-1, 0, -1):
		ans = (ans + (s[i] == '1')) * inv2 % MOD
	print((n - 1 + ans) % MOD)
