import sys
read = sys.stdin.readline
write = sys.stdout.write

for _ in range(int(read())):
	n = int(read())
	a = [*map(int, read().split())]
	b = [*map(int, read().split())]
	# if a[i] = b[i] for some i, we can guarantee i equal
	# additionally if a[i] = a[i+1] or b[i] = b[i+1] we can do the same
	if a[-1] == b[-1]:
		write(str(n) + '\n')
		continue
	ans = -1
	seen = [False for _ in range(n+1)]
	for i in range(n-2, -1, -1):
		if a[i] == b[i]:
			ans = i
			break
		if a[i] == a[i+1] or b[i] == b[i+1]:
			ans = i
			break
		if seen[a[i]] or seen[b[i]]:
			ans = i
			break
		seen[a[i+1]] = True
		seen[b[i+1]] = True

	write(str(ans+1) + '\n')
