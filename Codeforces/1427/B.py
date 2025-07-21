# wow am I really this bad at cf at 1:30am

for _ in range(int(input())):
	n, k = map(int, input().split())
	s = input().strip()
	streaks, Ws, Ls, goofs = 0, s.count('W'), s.count('L'), []
	for i in range(n):
		if s[i] == 'W' and (i == 0 or s[i - 1] == 'L'):
			streaks += 1
		elif s[i] == 'L':
			if i == 0 or s[i - 1] == 'W':
				goofs.append(0)
			goofs[-1] += 1
	if k >= Ls:
		print(2*n-1)
		continue
	if Ws == 0:
		print(0 if k == 0 else 2*k-1)
		continue
	if s[0] == 'L':
		goofs[0] = int(1e9)
	if s[-1] == 'L':
		goofs[-1] = int(1e9)
	goofs.sort()
	Ws += k
	for i in range(len(goofs)):
		if goofs[i] <= k:
			k -= goofs[i]
			streaks -= 1
		else:
			break
	print(2 * Ws - streaks)