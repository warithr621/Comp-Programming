# https://codeforces.com/contest/1730/problem/A

for _ in range(int(input())):
	n, c = map(int, input().split())
	a = list(map(int, input().split()))
	f = [0] * 105
	for i in a: f[i] += 1;
	ans = 0
	for i in f:
		if i != 0: ans += min(c, i);
	print(ans)