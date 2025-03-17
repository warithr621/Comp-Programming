# https://codeforces.com/contest/2075/problem/A

def solve(n, k):
	if n == k:
		return 1
	ans = 0
	if n % 2 == 1:
		if k % 2 == 1:
			n -= k
		else:
			n -= (k - 1)
		ans += 1
	k = k // 2 * 2
	return ans + (n + k - 1) // k

for _ in range(int(input())):
	n, k = map(int, input().split())
	print(solve(n, k))