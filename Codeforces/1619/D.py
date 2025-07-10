# start: 12:00
# bruh had to peak at edi but i was overthinking idea insanely
# i was thinking some weird greedy binsearch abt grabbing friend gifts as close to M as possible
# but crazy edge cases occur
# end: 12:26

for TT in range(int(input())):
	input() # why is there blank line, who made this problem
	m, n = map(int, input().split())
	p = []
	for i in range(m):
		p.append([*map(int, input().split())])
	# print(p)

	# m = no. of shops, n = no. of friends
	# we want to pick at most n-1 shops and grab gifts to maximize the min joy
	
	L, R = 0, int(1e9) + 1 # LMAO I CHANGED R FOR SAMPLE TC AND FORGOT TO CHANGE TO SUBMIT
	while L < R:
		M = (L + R + 1) // 2
		# can we make min(a[i]) at least M?
		# key idea: we need two conditions to hold for M to work
			# a shop must exist with >= 2 gifts of at least M
		# all friends must have a shop that meets that joy
		# this is at most n-1 (not n because of the pair condition)
		friends = set()
		pair = False
		for i in range(m):
			cnt = 0
			for j in range(n):
				if p[i][j] >= M:
					cnt += 1
					friends.add(j)
			if cnt >= 2:
				pair = True
		if len(friends) == n and pair:
			L = M
		else:
			R = M-1

	print(L)
