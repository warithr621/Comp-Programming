from math import sqrt

K = int(input())
if K == 0: # BRO :sob: i would def miss this in contest
	print("a")
	exit()

ans = ""
cur = ord('a')
while K != 0:
	# find the biggest V such that V * (V-1) / 2 <= K
	# V^2 - V - 2K <= 0
	# (1 + sqrt(1 + 8K)) / 2, floored
	V = int((1 + sqrt(1 + 8 * K)) / 2)
	ans += chr(cur) * V
	cur += 1
	K -= V * (V-1) // 2
print(ans)