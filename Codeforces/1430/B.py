# 58 sec

for _ in range(int(input())):
	n, k = map(int, input().split())
	a = [*map(int, input().split())]
	a.sort(reverse=True)
	print(sum(a[:k+1]))