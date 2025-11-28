n = int(input())
projects = []
compressed = set()
for _ in range(n):
	a, b, p = map(int, input().split())
	projects.append((a, b+1, p))
	compressed.add(a)
	compressed.add(b+1)
compressed = sorted(list(compressed))
# turn this into a lookup map
lookup = {v: i for i, v in enumerate(compressed)}
events = [[] for _ in range(len(compressed))]
for a, b, p in projects:
	events[lookup[b]].append((lookup[a], p))

dp = [0 for _ in range(len(compressed))]
for i in range(1, len(compressed)):
	dp[i] = dp[i-1]
	for a, p in events[i]:
		dp[i] = max(dp[i], dp[a] + p)
# print(compressed)
# print(events)
# print(dp)
print(dp[-1])