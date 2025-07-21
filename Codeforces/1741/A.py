# https://codeforces.com/contest/1741/problem/A

for _ in range(int(input())):
    A, B = map(str, input().split())
    if A[-1] == B[-1]:
        if len(A) == len(B):
            print("=")
        elif A[-1] == 'S':
            print(">" if len(A) < len(B) else "<")
        else:
            print("<" if len(A) < len(B) else ">")
    else:
        print(">" if A[-1] < B[-1] else "<")