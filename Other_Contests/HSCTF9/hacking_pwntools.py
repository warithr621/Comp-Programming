# HSCTF9 algorithms/hacking

from pwn import *
import json
import time

io = remote("hacking.hsctf.com", 1337)
#blah blah initialization
print(io.recvline())
print(io.recvline())
print(io.recvline())
print(io.recvline())
print(io.recvline())
print(io.recvline())
#by then they give the stuff to run through the pow
s = input()
io.send(s.strip() + "\n")
#run through the pow then type the ans so pwntools can send it
print(io.recvline())
print(io.recvline())
ret = ""
x = open("files.txt", "w")
for i in range(5):
	s = io.recvline().decode() #line 1-5
	s = "[" + s + "]"
	L = json.loads(s)
	for j in range(len(L)):
		x.write(str(L[j]))
		if j != len(L) - 1:
			x.write(", ")
	x.write("\n")
x.close()
s = input()
io.send(s.strip() + "\n")
time.sleep(60)
print(io.recvline())
print(io.recvline())
print(io.recvline())
print(io.recvline())
print(io.recvline())
print(io.recvline())
