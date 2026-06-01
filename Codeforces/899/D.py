from math import log10

n = int(input())
# min for one 9 is 5
# min for two 9s is 50
# min for three 9s is 500
# hm, sastisfying
if n <= 4:
	# zero 9s
	print(n*(n-1)//2)
	exit()

k = int(log10(n/5))+1 # number of 9s
m = 10**k
# we want sum to be m-1, 2m-1, 3m-1, etc.
# let's count ordered pairs, so enforce x < y to make x + y = s
	# x < s-x, so x <= (s-1)//2
	# s-x <= n, so x >= s-n
	# thus max(1,s-n) <= x <= (s-1)//2
	# so number of such x is min((s-1)//2, (2n+1-s)//2)
ans = 0
limit = (2*n-(m-1))//m
for i in range(limit + 1):
	s = (i+1) * m - 1
	ans += min((s-1)//2, (2*n+1-s)//2)
print(ans)