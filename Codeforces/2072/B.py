for _ in range(int(input())):
	n = int(input())
	s = input()
	d, u = s.count('-'), s.count('_')
	print(u * (d//2) * (d - d//2))