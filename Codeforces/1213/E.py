n = int(input())
s, t = input(), input()

a = ['abc', 'acb', 'bac', 'bca', 'cab', 'cba']
for perm in a:
	t1 = perm * n
	t2 = (perm[0] * n) + (perm[1] * n) + (perm[2] * n)
	if s not in t1 and t not in t1:
		print("YES")
		print(t1)
		exit()
	if s not in t2 and t not in t2:
		print("YES")
		print(t2)
		exit()

print("NO")