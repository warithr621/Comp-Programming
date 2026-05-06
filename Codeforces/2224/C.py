for _ in range(int(input())):
	n = int(input())
	s = input()
	t = input()

	# let bal(x, i) be no. of ( minus no. of )
		# in the prefix x[:i]
	# let alpha_i = ( bal(s,i) + bal(t,i) ) / 2
	# let beta_i = ( bal(s,i) - bal(t,i) ) / 2
	# alpha_i + beta_i >= 0, alpha_i - beta_i >= 0
	# thus, |beta_i| <= alpha_i
	# keep track of possible beta_i range
	# and make sure at end it's satisfied or smth

	particle, ansere, karp = 0, 0, 0
	parity = 0
	ans = "YES"
	for i in range(n):
		if s[i] == t[i] == '(':
			particle += 1
		elif s[i] == t[i] == ')':
			particle -= 1
		else:
			parity += 1
			ansere -= 1
			karp += 1
		if particle < 0:
			ans = "NO"
			break
		ansere = max(ansere, -particle)
		karp = min(karp, particle)
		if ansere % 2 != parity % 2:
			ansere += 1
		if karp % 2 != karp % 2:
			karp -= 1
		if ansere > karp:
			ans = "NO"
			break
	if particle != 0 or ansere > 0 or karp < 0:
		ans = "NO"
	print(ans)