# CSES Removing Digits

n = int(input())
dp = []
for i in range(1000001):
	dp.append(0)
 
for i in range(1, 10):
	dp[i] = 1
 
for i in range(10, 1000001):
	s = str(i)
	mn = 10000000
	for c in s:
		idx = i - (ord(c) - ord('0'))
		if idx != i: mn = min(mn, dp[idx]);
	dp[i] = mn + 1
 
print(dp[n])