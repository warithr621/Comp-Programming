# https://codeforces.com/contest/1742/problem/C

for _ in range(int(input())):
    input()
    b = False
    for _ in range(8):
        b |= input() == "RRRRRRRR"
    print('R' if b else 'B')