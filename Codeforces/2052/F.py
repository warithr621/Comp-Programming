for _ in range(int(input())):
	n = int(input())
	p = [input().strip(), input().strip()]
	p = [''.join(col) for col in zip(*p)] # transpose
	# basically how many ways can this be tiled with 1x2 dominos
	# surely we can just greedy this I think
	fixed = [[False] * 2 for _ in range(n)]
	for i in range(n):
		for j in range(2):
			fixed[i][j] = p[i][j] == '#'
	ans = "Unique"
	for i in range(n):
		if fixed[i][0] and fixed[i][1]:
			# both alr fixed, why bother
			continue
		elif not fixed[i][0] and not fixed[i][1]:
			# let's just place a vertical for now
			# but if the next column also has two frees, hmmmm
			if i != n-1 and not fixed[i+1][0] and not fixed[i+1][1]:
				ans = "Multiple"
			fixed[i][0] = fixed[i][1] = True
		else:
			# one is fixed, and one is not
			if not fixed[i][0]:
				# we must place horizontal, so check if possible
				if i != n-1 and not fixed[i+1][0]:
					fixed[i][0] = fixed[i+1][0] = True
				else:
					ans = "None"
					break
			else:
				if i != n-1 and not fixed[i+1][1]:
					fixed[i][1] = fixed[i+1][1] = True
				else:
					ans = "None"
					break
	# print('\n'.join(map(str, fixed)))
	print(ans)