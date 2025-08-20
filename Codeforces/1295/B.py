for _ in range(int(input())):
	n, x = map(int, input().split())
	s = input()
	z = s.count('0')
	o = s.count('1')
	end = z-o
	if end == 0:
		bal = 0
		found = (x == 0)
		for i in range(n):
			bal += (1 if s[i] == '0' else -1)
			if bal == x:
				found = True
				break
		print(-1 if found else 0)
		continue

	ans, bal = 0, 0
	for i in range(n):
		diff = x - bal
		if diff % end == 0 and diff // end >= 0:
			ans += 1
		bal += (1 if s[i] == '0' else -1)
	print(ans)