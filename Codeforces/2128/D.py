def in_li(num=True):
	return [*map(int if num else str, input().split())]

def solve():
	#code
	n = int(input())
	p = in_li()
	dp = [0] * (n+1)
	dp[n-1] = 1
	for i in range(n-2, -1, -1):
		dp[i] = dp[i + (1 if p[i] > p[i+1] else 2)] + n - i
	print(sum(dp))

t = int(input())
for quack in range(t):
	solve()
