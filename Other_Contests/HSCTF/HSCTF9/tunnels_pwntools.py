# HSCTF9 algorithms/tunnels

from pwn import *

perm = [5, 2, 7, 4, 4, 7, 2, 5]
while True:
    io = remote("tunnels.hsctf.com", 1337)
    print(io.recvline())
    for i in range(200):
        print(io.recvline())
        for j in range(8):
            io.send(str(perm[j])+"\n")
            if io.recvline().decode().find("incorrect") == -1:
                break
    print(io.recvline().decode())
    s = io.recvline().decode()
    print(s.encode())
    if s.find("better luck") == -1:
        print(io.recvline())
        print(io.recvline())
        print(io.recvline())
        print(io.recvline())
        print(io.recvline())
        print(io.recvline())
        print(io.recvline())
        print(io.recvline())
        break
