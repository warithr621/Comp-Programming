# https://codeforces.com/contest/1764/problem/B

def gcd(a,b):
    if b == 0:
        return a
    return gcd(b, a%b)
    
for _ in range(int(input())):
    N,A = int(input()), list(map(int, input().split()))
    G = A[0]
    for i in range(1,N):
        G = gcd(G, A[i])
    
    print(A[-1] // G + (1 if A[0] == 0 else 0))