for _ in range(int(input())):
	n = int(input())
	s = input()
	print(s.count('01') + s.count('10') + (1 if s[0] == '1' else 0))