n = int(input())
ans = True
for i in range(3):
	arr = list(map(int, input().split()))
	if 7 not in arr:
		ans = False
print(777 if ans else 0)