for _ in range(int(input())):
	#code
	s = input()
	ans = len(s)
	s = [c for c in s if c != '4']
	# a string is beautiful if either
		# a 4 exists
		# a 1 and 2 exist in that order
		# a 3 and 2 exist in that order
	# essentially just split the string, and take only even from left and only odd from right
	pfx = [0] # number of evens
	for c in s:
		pfx.append(pfx[-1] + (c == '2'))
	best = 0
	for i in range(len(s)+1):
		best = max(best, pfx[i] + (len(s) - i - (pfx[-1] - pfx[i])))
	print(ans - best)