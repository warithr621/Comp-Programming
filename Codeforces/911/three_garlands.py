# https://codeforces.com/contest/911/problem/C

a,b,c = map(int, input().split())

val = [0]
for i in range(1600): val.append(0);
val[a] += 1
val[b] += 1
val[c] += 1

if val[1] >= 1 or val[2] >= 2 or val[3] == 3 or (val[2] == 1 and val[4] == 2):
	print("YES")
else:
	print("NO")