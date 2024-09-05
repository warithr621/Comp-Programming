# https://codeforces.com/contest/2009/problem/B

for _ in range(int(input())):
    n = int(input())
    a = []
    for q in range(n):
        a.append(input())
    ans = []
    for s in a:
        ans.append(s.index('#') + 1)
    print(' '.join(map(str, ans[::-1])))