from collections import defaultdict

# precomputation
precomp = defaultdict(tuple)
for a in range(64):
	for b in range(64):
		val = (1 << a) - (1 << b)
		precomp[val] = (a, b)

for _ in range(int(input())):
	n = int(input())
	a = [*map(int, input().split())]
	S = sum(a)
	if S % n != 0:
		print("NO")
		continue
	goal = S // n
	first, second = [], []
	works = True
	for x in a:
		diff = x - goal
		if diff not in precomp:
			works = False
			break
		f, s = precomp[diff]
		first.append(f)
		second.append(s)
	if works and sorted(first) == sorted(second):
		print("Yes")
	else:
		print("No")