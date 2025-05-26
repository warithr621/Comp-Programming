N = int(input())
ans = []
while N != 0:
	S, T = str(N), ""
	for c in S:
		T += '0' if c == '0' else '1'
	ans.append(int(T))
	N -= ans[-1]
print(len(ans))
print(' '.join(map(str, ans)))