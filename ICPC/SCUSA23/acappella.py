n, d = map(int, input().split())
p = []
for _ in range(n):
	p.append(int(input()))

p.sort()
# make blocks where max - min <= d
blocks = []
cur_min = p[0]
for i in range(1, n):
	if p[i] - cur_min > d:
		blocks.append(cur_min)
		cur_min = p[i]

blocks.append(cur_min)
print(len(blocks))