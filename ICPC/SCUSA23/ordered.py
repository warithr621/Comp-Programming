n = int(input())
a = []
for _ in range(n):
	a.append(int(input()))

works = []
for k in range(2, n+1):
	if n % k != 0:
		continue
	# make k blocks
	block_size = n // k
	blocks = []
	for i in range(n):
		if not blocks or len(blocks[-1]) == block_size:
			blocks.append([])
		blocks[-1].append(a[i])
	# do the blocks work?
	ok = True
	for i in range(k-1):
		if max(blocks[i]) > min(blocks[i+1]):
			ok = False
			break
	if ok:
		works.append(k)

print('\n'.join(map(str, works)) if works else -1)