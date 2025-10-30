for _ in range(int(input())):
	n = int(input())
	s = list(input())
	t = list(input())
	# build a combined frequency list
	freq = [0] * 26
	for i in range(n):
		freq[ord(s[i]) - ord('a')] += 1
		freq[ord(t[i]) - ord('a')] += 1
	# check if all frequencies are even
	if any(f % 2 != 0 for f in freq):
		print("No")
		continue
	print("yes") # this is sufficient i think

	ops = []
	for i in range(n):
		if s[i] == t[i]:
			continue
		# find a j such that either s[i] = s[j] or s[i] = t[j]
		j = i+1
		while j < n:
			if s[i] == s[j]:
				# swap s[j] with t[i]
				s[j], t[i] = t[i], s[j]
				ops.append((j+1, i+1))
				break
			elif s[i] == t[j]:
				# swap t[j] with s[j] then s[j] with t[i]
				s[j], t[j] = t[j], s[j]
				ops.append((j+1, j+1))
				s[j], t[i] = t[i], s[j]
				ops.append((j+1, i+1))
				break
			j += 1
	print(len(ops))
	print('\n'.join(f"{x[0]} {x[1]}" for x in ops))