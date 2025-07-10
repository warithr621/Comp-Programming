from collections import deque

# do funny prime bs
# first, find the biggest prime factor of each integer
biggest = [1 for _ in range(100005)]
for i in range(2, 100005):
	if biggest[i] == 1:
		for j in range(i, 100005, i):
			biggest[j] = i

for _ in range(int(input())):
	n = int(input())
	# let a[i] contain all numbers in [1,n] interval with biggest prime p
	a = [deque() for _ in range(n+1)]
	for i in range(1, n+1):
		a[biggest[i]].append(i)
	for p in range(2, n+1):
		if a[p]:
			a[p].rotate(1)
	ans = []
	for i in range(1, n+1):
		ans.append(a[biggest[i]].popleft())
	print(*ans)