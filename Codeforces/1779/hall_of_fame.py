# https://codeforces.com/contest/1779/problem/A

def solve():
    N = int(input())
    S = input()
    
    for i in range(N-1):
        if S[i:i+2] == "LR":
            print(i+1)
            return
        if S[i:i+2] == "RL":
            print(0)
            return
        
    print(-1)

for _ in range(int(input())):
    solve()