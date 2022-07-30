# https://codeforces.com/contest/1698/problem/D

import sys

def query(left, right):
	print("? %d %d" % (left, right))

def solve():
	n = int(input())
	l = 1
	r = n
	while l < r:
		m = (l + r) // 2
		query(l, m)
		ret = list(map(int, input().split()))
		works = [i for i in ret if l <= i and i <= m]
		if len(works) & 1 == 1:
			r = m
		else:
			l = m + 1
	print("! " + str(l))

for _ in range(int(input())): solve();