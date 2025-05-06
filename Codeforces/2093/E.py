def works(a, M, k):
    seen = [False for _ in range(M)]
    ans, cnt = 0, 0
    for i in range(len(a)):
        # if the MEX of a subarray is "M",
        # there must be at least M elements (0 - (M-1))
        if a[i] >= M:
            continue
        if not seen[a[i]]:
            seen[a[i]] = True
            cnt += 1
        if cnt == M:
            seen = [False for _ in range(M)]
            ans += 1 # we can form a subarray with this MEX
            cnt = 0
    return ans >= k
    # if we can make at least k, we can make exactly k by combining

def solve():
    # code
    n, k = map(int, input().split())
    a = [*map(int, input().split())]
    # binary search on x???
    L, R = 0, n + 1
    while L < R:
        M = (L + R + 1) >> 1
        if works(a, M, k):
            L = M
        else:
            R = M - 1
    print(L)

t = int(input())
for quack in range(t):
    solve()