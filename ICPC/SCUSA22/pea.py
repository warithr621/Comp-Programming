from collections import Counter

n, m = input().split()
if n == m:
	print(1)
	exit()

vis = set([n])
cur, itr = n, 2
while itr < 174:
	c = Counter(cur)
	nxt = ''
	for ch in sorted(c):
		nxt += str(c[ch]) + str(ch)
	# print(nxt)
	if nxt == m:
		print(itr)
		exit()
	if nxt in vis:
		print('Does not appear')
		exit()
	vis.add(nxt)
	cur = nxt
	itr += 1
print('Does not appear')