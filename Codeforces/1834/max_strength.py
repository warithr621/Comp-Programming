# https://codeforces.com/contest/1834/problem/B

for _ in range(int(input())):
    L, R = map(str, input().split()) # note, max of 10^100
    while len(L) != len(R):
        if len(L) < len(R):
            L = '0' + L
        else:
            R = '0' + R
            
    i = 0
    while i < len(L) and L[i] == R[i]:
        i += 1
    if i == len(L):
        print(0)
    else:
        print( ord(R[i]) - ord(L[i]) + 9 * (len(L) - i - 1))