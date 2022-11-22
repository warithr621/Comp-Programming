# https://codeforces.com/contest/1379/problem/A

import sys
read = sys.stdin.readline
write = sys.stdout.write
wanted = "abacaba"

def substr(s):
	cnt = 0
	idx = 0
	while idx + 6 < len(s):
		if wanted == s[idx:idx+7]:
			cnt += 1
		idx += 1
	return cnt

def solve():
	n = int(read())
	s = read()
	if substr(s) > 1:
		write("No\n")
		return
	if substr(s) == 1:
		write("Yes\n")
		write(s.replace('?', 'z') + '\n')
		return

	idx = 0
	works = []
	while idx + 6 < n:
		cur = ""
		for j in range(idx, idx+7):
			if s[j] == '?':
				cur += wanted[j-idx]
			else: 
				cur += s[j]
		if cur == "abacaba":
			works.append(idx)
		idx += 1
	if len(works) == 0:
		write("nO\n")
		return

	for test in works:
		pray = ""
		for i in range(n):
			if test <= i and i <= test + 6:
				pray += wanted[i - test]
			elif s[i] == '?':
				pray += 'z'
			else:
				pray += s[i]
		if substr(pray) == 1:
			write("YES\n" + pray + '\n')
			return

	write("no\n")


for _ in range(int(read())): solve();