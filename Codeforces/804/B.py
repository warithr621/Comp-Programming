MOD = int(1e9) + 7
S = input()

# any time you do the op, you turn ab into bba
# final state is gonna be bb...bbbaa...aa
# a "b" should essentially double for every "a" before it
# e.g. aa*b* -> aBba -> BBaba -> BBbbaa
cnta = 1
cntb = 0
ans = 0
for c in S:
	if c == 'a':
		cnta = (cnta << 1) % MOD
	else:
		ans = (ans + cnta) % MOD
		cntb = (cntb + 1) % MOD
# ans is now the number of b's in the final string
print((ans - cntb + MOD) % MOD)