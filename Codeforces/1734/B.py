# https://codeforces.com/contest/1734/problem/B

for _ in range(int(input())):
	n = int(input())
	for i in range(1, n+1):
		for j in range(1, i+1):
			print(1 if j == 1 or j == i else 0, end = ' ')
		print()