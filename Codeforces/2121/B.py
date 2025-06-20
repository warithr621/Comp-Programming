for _ in range(int(input())):
	n = int(input())
	s = input()
	# does there exist a,b,c such that
	# a + b + c = s
	# b is a substring of a+c
	# ?
	# this always works as long as some letter 'b' exists
	# such that there is at least two of 'b', but not only at both ends
	works = False
	for tmp in range(ord('a'), ord('z')+1):
		c = chr(tmp)
		if s.count(c) > 2 or (s.count(c) == 2 and not(s[0] == c and s[-1] == c)):
			works = True
			break
	print("Yes" if works else "No")