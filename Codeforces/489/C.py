# https://codeforces.com/problemset/problem/489/C

def sm(s):
    ans = 0
    for x in s:
        ans += ord(x) - 48
    return ans

def test(m, s):
    return s >= 0 and s <= 9 * m

def smol(M, S):
    STR = ""
    for i in range(M):
        for d in range(10):
            if (i > 0 or d > 0 or (d == 0 and M == 1)) and test(M - i - 1, S - d):
                STR += chr(48 + d)
                S -= d
                break
    return STR
    
def chonk(M, S):
    STR = ""
    for i in range(M):
        for d in range(9, -1, -1):
            if (i > 0 or d > 0 or (d == 0 and M == 1)) and test(M - i - 1, S - d):
                STR += chr(48 + d)
                S -= d
                break
    return STR

M, S = map(int, input().split())
A, B = smol(M, S), chonk(M, S)
        
print(-1 if len(A) != M or sm(A) != S else A, -1 if len(B) != M or sm(B) != S else B)