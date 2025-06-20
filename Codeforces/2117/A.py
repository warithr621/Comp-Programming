for _ in range(int(input())):
	n, x = map(int, input().split())
	a = [*map(int, input().split())]
	a = ''.join(map(str, a))
	if a.count('1') == 0 or a.rfind('1') - a.find('1') + 1 <= x:
		print("YES")
	else:
		print("NO")