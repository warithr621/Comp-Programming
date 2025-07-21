# https://codeforces.com/contest/1742/problem/F

for _ in range(int(input())):
    q = int(input())
    oa = ob = False
    ca = cb = 0
    for _ in range(q):
        d,k,s = map(str, input().split())
        for c in s:
            if int(d) == 1:
                if c != 'a':
                    oa = True
                else:
                    ca += int(k)
            else:
                if c != 'a':
                    ob = True
                else:
                    cb += int(k)
                    
        print("YES" if ob or (not oa and ca < cb) else "NO")