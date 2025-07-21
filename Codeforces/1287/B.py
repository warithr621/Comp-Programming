# https://codeforces.com/contest/1287/problem/B
# 晴れ 晴れ

import sys
read = sys.stdin.readline
write = sys.stdout.write

def make(a, b):
    ret = ""
    for i in range(len(a)):
        if a[i] == b[i]:
            ret += a[i]
        else:
            num = 6 - (ord(a[i]) - ord('0')) - (ord(b[i]) - ord('0'))
            ret += chr(ord('0') + num)
    return ret
    
def conv(a):
    return a.replace('S', '1').replace('E', '2').replace('T', '3')

N, K = map(int, read().split())
cards = set()
A = []
for _ in range(N):
    A.append(conv(read()))
    cards.add(A[-1])

ans = 0
for i in range(N):
    for j in range(i+1, N):
        # use A[i] and A[j] to see if their triple exists
            if make(A[i], A[j]) in cards:
                ans += 1
            
write(str(ans//3) + '\n')