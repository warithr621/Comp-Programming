# https://codeforces.com/contest/883/problem/F

import sys
read = sys.stdin.readline
write = sys.stdout.write

SET = set()
for _ in range(int(read())):
	s = read()
	s = s.replace("u", "oo")
	while s.count("kh") != 0:
		s = s.replace("kh", "h")
	SET.add(s)
write(str(len(SET)) + '\n')