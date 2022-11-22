# https://codeforces.com/contest/1102/problem/D

n = int(input())
s = [ord(f) - ord('0') for f in input()]
freq = [s.count(f) for f in [0, 1, 2]]

def check(x):
	for i in range(n):
		if freq[x] < n // 3 and s[i] > x and freq[s[i]] > n // 3:
			freq[x] += 1
			freq[s[i]] -= 1
			s[i] = x
def checkrev(x):
	for i in range(n-1, -1, -1):
		if freq[x] < n // 3 and s[i] < x and freq[s[i]] > n // 3:
			freq[x] += 1
			freq[s[i]] -= 1
			s[i] = x

#step 1: change 1/2 to 0
check(0)
#step 2: change 2 to 1
check(1)
#step 3: change 0/1 to 2
checkrev(2)
#step 4: change 0 to 1
checkrev(1)

print(''.join(map(str, s)))