# n tables labeled 1 through n
# each customer either wants tai (0) or chin (1)
# you want all customers at the same table to have the same number
# compute min. number of customers you must move

INF = int(1e9)
n = int(input())
dp = [0, INF, INF, INF]
c0, c1 = 0, 0
for i in range(n):
	s = input()
	cnt = [s.count('0'), s.count('1')]
	c0, c1 = c0 + cnt[0], c1 + cnt[1]
	ndp = [INF, INF, INF, INF]
	for t in range(4):
		for j in range(2):
			ndp[t | (1 << j)] = min(ndp[t | (1 << j)], dp[t] + cnt[j])
	# print(dp, ndp, sep='\n')
	dp = ndp

print(0 if min(c0,c1) == 0 else dp[3])