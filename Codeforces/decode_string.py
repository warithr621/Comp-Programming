# https://codeforces.com/contest/1729/problem/B

def solve():
	n = int(input())
	s = input()
	ans = ""
	idx = n-1
	while idx >= 0:
		if s[idx] == '0':
			x = (ord(s[idx-2]) - 48) * 10 + ord(s[idx-1]) - 49
			ans += chr(97 + x)
			idx -= 3
		else:
			ans += chr(ord(s[idx]) + 48)
			idx -= 1

	print(ans[::-1])
	

for _ in range(int(input())):
	solve()