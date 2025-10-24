from itertools import permutations

n = int(input())
a = [*map(int, input().split())]
b = [*map(int, input().split())]

ans2 = min(a[0], b[1]) + min(a[1], b[2]) + min(a[2], b[0]) # max wins possible
ans1 = n # min wins possible
options = [(0,0), (0,2), (1,0), (1,1), (2,1), (2,2)]
for p in permutations(options):
	aa = a[:]
	bb = b[:]
	for i,j in p:
		t = min(aa[i], bb[j])
		aa[i] -= t
		bb[j] -= t
	ans1 = min(ans1, aa[0] + aa[1] + aa[2])
print(ans1, ans2)