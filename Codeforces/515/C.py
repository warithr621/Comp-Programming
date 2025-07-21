#problem: https://codeforces.com/problemset/problem/515/C

n = int(input())
s = input()
L = []

for i in range(n):
    x = ord(s[i]) - 48
    if x == 2 or x == 4 or x == 8 or x == 9:
        L.append(2)
    if x == 3 or x == 4 or x == 6 or x == 9:
        L.append(3)
    if x == 5 or x == 6:
        L.append(5)
    if x == 7 or x == 8 or x == 9:
        L.append(7)
    if x == 4 or x == 8:
        L.append(2)
    if x == 8:
        L.append(2)
    if x == 9:
        L.append(3)
L.sort(reverse=True)
for j in range(len(L)):
    print(L[j], end='')
