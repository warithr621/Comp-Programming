# HSCTF10 algo/producing-3s

from pwn import *
import json
import time

io = remote("producing-3s.hsctf.com", 1337)

T = int(io.recvline().decode()) # number of test cases
ans = ""
for _ in range(T):
    N = int(io.recvline().decode()) # number of elements
    tmp = io.recvline().split()
    A = [] # array of elements
    for x in tmp:
        A.append(abs(int(x)) % 10) # only the last digit  matters
    YES = [False for i in range(10)]
    YES[1] = True
    for i in range(N):
        ok = False
        for j in range(10):
            if YES[j] and j * A[i] % 10 == 3:
                    ok = True
        C = [i for i in YES]
        for j in range(10):
            if YES[j]:
                C[j * A[i] % 10] = True
        YES = C
        ans += ("Y" if ok else "N")
        YES[A[i]] = True
    ans += '\n'

    print("{0:0.2f}% done".format((_+1) / T * 100)) # progress indicator

io.send(ans.strip()+'\n')

print(io.recvline().decode())
print(io.recvline().decode())
print(io.recvline().decode())