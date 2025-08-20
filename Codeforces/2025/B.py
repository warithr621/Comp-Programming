n = int(input())
a = [*map(int, input().split())]
k = [*map(int, input().split())]
for v in k:
	print(pow(2, v, MOD))