from collections import defaultdict

n = int(input())
a = [input().strip() for _ in range(n)]
cnt = defaultdict(int)

for s in a:
	seen = set()
	for i in range(9):
		for j in range(i+1, 9+1):
			seen.add(s[i:j])
	for sub in seen:
		cnt[sub] += 1

ans = []
for s in a:
	best = s
	for length in range(1, 9):
		for i in range(9 - length + 1):
			sub = s[i:i + length]
			if cnt[sub] == 1:
				best = sub
				break
		if best != s:
			break
	ans.append(best)

print('\n'.join(ans))