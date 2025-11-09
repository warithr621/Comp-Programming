a = input()
b = input()

def comp(a, b):
	a, b = a.split('.'), b.split('.')
	a = (int(a[0]), int(a[1]))
	b = (int(b[0]), int(b[1]))
	return 1 if a > b else -1 if a < b else 0

if float(a) > float(b) and comp(a,b) == 1:
	print(a)
elif float(a) < float(b) and comp(a,b) == -1:
	print(b)
else:
	print(-1)