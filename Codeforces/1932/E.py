for _ in range(int(input())):
	N = int(input())
	S = input()

	pfx = [0] * (N + 1)
	for i in range(N):
		pfx[i + 1] = pfx[i] + (ord(S[i]) - ord('0'))
	pfx = (pfx[1:])[::-1]
	carry = 0
	ans = []
	for val in pfx:
		val += carry
		ans.append(str(val % 10))
		carry = val // 10
	while carry > 0:
		ans.append(str(carry % 10))
		carry //= 10

	print(''.join(ans[::-1]).lstrip('0'))