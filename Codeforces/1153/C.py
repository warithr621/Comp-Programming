n = int(input())
s = input()
cur = s.count('(') - s.count(')')
empty = s.count('?')
# L + R = empty, L - R = -cur
L = (empty - cur) // 2
R = empty - L
if (empty - cur) % 2 != 0 or L < 0 or R < 0:
	print(":(")
	exit()

s = list(s)
for i in range(n):
	if s[i] == '?':
		if L > 0:
			s[i] = '('
			L -= 1
		else:
			s[i] = ')'
s = ''.join(s)

# does this satisfy the problem?
stack = 0
for i in range(n):
	if s[i] == '(':
		stack += 1
	else:
		stack -= 1
	if stack < 0:
		print(":(")
		exit()
	if stack == 0 and i != n-1:
		print(":(")
		exit()
print(s if stack == 0 else ":(")