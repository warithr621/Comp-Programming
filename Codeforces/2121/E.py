for _ in range(int(input())):
	l, r = map(str, input().split())
	n = len(l)
	if l == r:
		print(2 * n) # forced
	else:
		idx = 0 
		while idx < n and l[idx] == r[idx]:
			idx += 1
		if ord(l[idx]) + 1 < ord(r[idx]):
			print(2 * idx)
		else:
			ans = 2 * idx + 1
			for i in range(idx+1, n):
				if l[i] != '9' or r[i] != '0':
					break
				ans += 1
			print(ans)