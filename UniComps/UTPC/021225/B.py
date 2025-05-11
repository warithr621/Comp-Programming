N = int(input())
A = []
for _ in range(N):
    A.append(input())
mn = 'a' * 1000
for S in A:
    if len(mn) > len(S):
        mn = S

works = True
for S in A:
    works &= S.endswith(mn)

print(mn if works else "Not found")