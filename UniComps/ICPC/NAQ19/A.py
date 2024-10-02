# 2019 NAQ: Circuit Math

N = int(input())
V = [*map(str, input().split())]
V = [(True if i == 'T' else False) for i in V]
I = [*map(str, input().split())]
S = []
for X in I:
    if X == '+' or X == '*':
        A = S.pop()
        B = S.pop()
        S.append(A or B if X == '+' else A and B)
    elif X == '-':
        A = S.pop()
        S.append(not A)
    else:
        C = ord(X[0]) - ord('A')
        S.append(V[C])
print(str(S[0])[0])