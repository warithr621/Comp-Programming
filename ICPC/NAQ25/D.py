# D

import math
from collections import deque, defaultdict, Counter
from heapq import heappush, heappop
from itertools import product, permutations
MOD = 998244353

r, c = map(int, input().split())
start = tuple(map(int, input().split()))
end = tuple(map(int, input().split()))
start = (start[0]-1, start[1]-1)
end = (end[0]-1, end[1]-1)
grid = [input() for _ in range(r)]


current = (start[0], start[1])
vectors = [(0, 1), (1, 0), (0, -1), (-1, 0)]
cur_v = 0
vis = set() # this will store x-coord, y-coord, AND direction
while current != end:
	if (current[0], current[1], cur_v) in vis:
		print(0)
		exit()
	vis.add((current[0], current[1], cur_v))
	# now run the algorithm
	# first, can he turn left and see an empty square?
	left_v = (cur_v - 1 + 4) % 4
	nx, ny = current[0] + vectors[left_v][0], current[1] + vectors[left_v][1]
	if 0 <= nx < r and 0 <= ny < c and grid[nx][ny] == '0':
		cur_v = left_v
		current = (nx, ny)
		continue
	# can he just go straight?
	nx, ny = current[0] + vectors[cur_v][0], current[1] + vectors[cur_v][1]
	if 0 <= nx < r and 0 <= ny < c and grid[nx][ny] == '0':
		current = (nx, ny)
		continue
	# eh, just turn right
	cur_v = (cur_v + 1) % 4

print(1)