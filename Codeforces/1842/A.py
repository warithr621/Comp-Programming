# https://codeforces.com/contest/1842/problem/A

for _ in range(int(input())):
    input()
    a = []
    for __ in range(2):
        a.append(sum(list(map(int, input().split()))))
    if len(set(a)) == 1:
        print("Draw")
    else:
        print("Tsondu" if a[0] > a[1] else "Tenzing")