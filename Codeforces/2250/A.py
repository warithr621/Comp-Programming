for _ in range(int(input())):
	n = int(input())
	a = [*map(int, input().split())]
	if n % 2 == 1:
		print("NO")
		continue

	# for each even i, we have k < a[i] and k > a[i+1] must hold
	left, right = -1, int(1e9) + 1
	for i in range(0, n, 2):
		left = max(left, a[i+1] + 1)
		right = min(right, a[i] - 1)
	# must lie in [left, right]
	if left > right:
		print("No")
		continue
	# now does a number exist in this interval not already in a?
	# i don't think it's guaranteed a has distinct elements
	s = set()
	for x in a:
		if left <= x <= right:
			s.add(x)
	if (right - left + 1) > len(s):
		print("YES")
	else:
		print("nO")