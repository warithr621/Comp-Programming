import sys

n = int(sys.stdin.readline())
a = list(map(int, sys.stdin.readline().split()))

# the first row is like 0C0
# second row is 1C0 and 1C1
# third row is 2C0 2C1 2C2
# then 3C0 3C1 3C2 3C3
# so on so forth
# recall that nCk is odd if (n&k) == k
# smth smth SOS dp (i need to make sure i 200% understand this at some point sob)

for i in range(18):
	for j in range(n):
		if (j >> i) % 2 == 1:
			a[j] ^= a[j ^ (1 << i)]

sys.stdout.write(' '.join(map(str, a)))