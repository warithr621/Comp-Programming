a = ['0', '1']
for i in range(2, 11):
	a.append(a[-1] + str(i))

n = input()
if n not in a:
	print(-1)
else:
	print(a.index(n))