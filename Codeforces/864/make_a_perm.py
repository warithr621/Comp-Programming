# https://codeforces.com/contest/864/problem/D

N = int(input())
A = list(map(int, input().split()))
freq = [0 for _ in range(N+1)]
for x in A:
    freq[x] += 1
    
# make list of elements not present at all, size of this is the number of changes
missing = []
for i in range(N, 0, -1):
    if freq[i] == 0:
        missing.append(i)
print(len(missing))

# now adjust elements
vis = [False for _ in range(N+1)]
for i in range(N):
    if freq[A[i]] == 1:
        continue # already good
    if len(missing) != 0 and (missing[-1] < A[i] or vis[A[i]]):
        # we're still missing elements
        # and either this would decrease the thing (lexicographically min)
        # or it won't but we've already seen this element
        freq[A[i]] -= 1
        A[i] = missing.pop() # popping from end should be O(1) rather than O(N)
        freq[A[i]] += 1
    else:
        vis[A[i]] = True
    
print(' '.join(map(str, A)))