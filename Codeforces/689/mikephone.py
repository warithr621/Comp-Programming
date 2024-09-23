# https://codeforces.com/contest/689/problem/A

n = int(input())
s = [ord(c) - 48 for c in input()]
# edge
if n == 1:
	print("NO")
	exit()
# this brute force sucks LMAO im braindead
pos = [[3,1], [0,0], [0,1], [0,2], [1,0], [1,1], [1,2], [2,0], [2,1], [2,2]]
changes = []
for i in range(1, n):
	fst, sec = pos[s[i-1]], pos[s[i]]
	changes.append([sec[0] - fst[0], sec[1] - fst[1]])

for i in range(10):
	dup = True
	if i == s[0]:
		continue
	cur = pos[i]
	for c in changes:
		cur = [cur[0] + c[0], cur[1] + c[1]]
		if cur not in pos:
			# this combo doesnt work
			dup = False
			break
	# print(i, dup)
	if dup:
		print("NO")
		exit()
print("YES")