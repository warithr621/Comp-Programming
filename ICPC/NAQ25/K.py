# K

import math
from collections import deque, defaultdict, Counter
from heapq import heappush, heappop
from itertools import product, permutations
MOD = 998244353

# aaaaa
def query(x, y):
	print(f"? {x} {y}", flush=True)
	return int(input()) == 1
def answer(x, y):
	print(f"! {x} {y}", flush=True)
	exit()

if query(2,2):
	# check upper-left block
	if query(1,1):
		answer(1,1)
	elif query(1,2):
		answer(1,2)
	elif query(2,1):
		answer(2,1)
	else:
		answer(2,2)
elif query(2,4):
	# possibilities around top-right
	if query(1,3):
		answer(1,3)
	elif query(1,4):
		answer(1,4)
	elif query(2,3):
		answer(2,3)
	else:
		answer(2,4)
elif query(4,2):
	# possibilities around bottom-left
	if query(3,2):
		if query(3,1):
			answer(3,1)
		else:
			answer(3,2)
	else:
		if query(4,1):
			answer(4,1)
		else:
			answer(4,2)
else:
	# bottom-right area
	if query(3,4):
		if query(3,3):
			answer(3,3)
		else:
			answer(3,4)
	else:
		if query(4,3):
			answer(4,3)
		else:
			answer(4,4)