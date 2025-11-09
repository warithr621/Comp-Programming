S = input()
N = len(S)
# make pfx
pfx = [[0,0,0,0] for _ in range(N+1)]
lookup = list('ATGC')
for i in range(1, N+1):
	for j in range(4):
		pfx[i][j] = pfx[i-1][j]
	pfx[i][lookup.index(S[i-1])] += 1
# print('\n'.join(map(str, pfx)))

Q = int(input())
for _ in range(Q):
	L, R = map(int, input().split())
	aa = []
	for i,c in enumerate(lookup):
		aa.append((c, pfx[R][i]-pfx[L-1][i]))
	aa.sort(key=lambda x: (x[1], -lookup.index(x[0])), reverse=True)
	print(''.join([x[0] for x in aa]))