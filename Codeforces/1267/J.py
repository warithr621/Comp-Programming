from collections import Counter

def func(S, F):
	if S == 1:
		return F, 0
	R = F % (S-1)
	Y0 = (F - R*S) // (S-1)
	if Y0 < 0:
		return -1, -1
	k = Y0 // S
	return R + k * (S-1), Y0 - k * S

for _ in range(int(input())):
	n = int(input())
	a = [*map(int, input().split())]
	# we need to find M and S such that
	# 	we can form M groups of icons
	#	all groups have S or S-1 icons
	#	all icons in a particular group are the same number
	count = Counter(a)
	# for a particular frequency F, we need to find all S such that
	#	xS + y(S-1) = F for non-negative integers x and y
	#	(x+y)S - y = F
	#	wow how cursed would it be to use egcd on this
	freqs = [c for c in count.values()]
	mn = max(freqs)
	ans = []
	for S in range(1, mn+1):
		works = True
		tot = 0
		for elem in freqs:
			x, y = func(S, elem)
			if x == -1:
				works = False
				break
			# print(f"elem: {elem}, S: {S}, x: {x}, y: {y}")
			tot += x + y
		if works:
			ans.append((tot, S))
	ans.sort()
	# print(ans)
	print(ans[0][0])

