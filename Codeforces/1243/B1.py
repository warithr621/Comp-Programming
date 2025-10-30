for _ in range(int(input())):
	n = int(input())
	s = list(input())
	t = list(input())
	diff = [i for i in range(n) if s[i] != t[i]]
	if len(diff) != 2:
		print('no')
		continue
	# swap s[diff[0]] and t[diff[1]]
	# or s[diff[1]] and t[diff[0]]
	s[diff[0]], t[diff[1]] = t[diff[1]], s[diff[0]]
	if s == t:
		print('yes')
		continue
	s[diff[0]], t[diff[1]] = t[diff[1]], s[diff[0]]
	s[diff[1]], t[diff[0]] = t[diff[0]], s[diff[1]]
	print('yes' if s == t else 'no')