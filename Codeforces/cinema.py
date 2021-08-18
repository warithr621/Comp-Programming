#Problem: https://codeforces.com/problemset/problem/349/A

n = int(input())
L = list(map(int, input().split()))
tf = 0
f = 0
for i in range(n):
    if L[i] == 25:
        tf += 1
    elif L[i] == 50:
        if tf >= 1:
            tf -= 1
            f += 1
        else:
            print("NO")
            exit()
    else:
        if tf >= 1 and f >= 1:
            tf -= 1
            f -= 1
        elif tf >= 3:
            tf -= 3
        else:
            print("NO")
            exit()
print("YES")
