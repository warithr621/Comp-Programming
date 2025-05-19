def check(S, N, L):
	# this will return true if the string S has a tandem substring of length L
	# check S[0:L], then S[1:L+1], ..., S[N-L:N]
	matches = 0
	def match(idx):
		return S[idx] == '?' or S[idx + L//2] == '?' or S[idx] == S[idx + L//2]
	for i in range(L//2):
		# print("+", i)
		matches += (1 if match(i) else 0)
	# print("~", matches)
	if matches == L // 2:
		# print(0, L)
		return True
	for prev in range(N-L):
		# remove prev, add prev + L//2
		matches -= (1 if match(prev) else 0)
		matches += (1 if match(prev + L//2) else 0)
		# print("-", prev)
		# print("+", prev + L//2 - 1)
		# print("~", matches)
		if matches == L // 2:
			# print(prev+1, L)
			return True
	return False

for _ in range(int(input())):
	S = input()
	N = len(S)
	ans = 0
	# note binary search won't work for this problem
	# a length L working doesn't guarantee smaller ones do
	# a length L not working doesn't guarantee bigger ones don't
	for L in range(2, N+1, 2):
		if check(S, N, L):
			ans = L
		# print(f"Done checking length {L}")
	print(ans)