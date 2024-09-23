# https://codeforces.com/contest/2014/problem/A
# tried to make this as cursed as possible

for _ in range(int(input())):
	n, k = map(int, input().split())
	a = [*map(int, input().split())]
	r, p = 0, 0
	for α in a:
		if α >= k:
			r += α
		elif α == 0 and r != 0:
			r -= 1
			p += 1
	print(p)