n = int(input())
n <<= 1 # there are 2n elements lol
a = [*map(int, input().split())]
ans = int(1e9)
for i in range(n):
	for j in range(i+1, n):
		b = [a[k] for k in range(n) if k != i and k != j]
		b.sort()
		inst = 0
		for k in range(0, n-3, 2):
			inst += b[k+1] - b[k]
		# print(b, inst)
		ans = min(ans, inst)
print(ans)