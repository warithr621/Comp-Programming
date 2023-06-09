# HSCTF10 algo/bank

from pwn import *
io = remote("bank.hsctf.com", 1337)

for _ in range(5):
    x = io.recvline().decode()
    print(x)
    N = int(x)
    accs = []
    for _ in range(N):
        a,b = map(int, io.recvline().split())
        print(a, b)
        if b - a < 10:
            continue
        accs.append((b, a))
    accs.sort()
    ans = 0
    c = accs[0][1]
    for i in range(N):
        if accs[i][0] - c >= 10:
            ans += 1
            c = max(accs[i][1] + 10, c + 10)
    print(ans)
    io.send(str(ans) + '\n')

print(io.recvline().decode())