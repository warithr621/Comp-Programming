# HSCTF10 algo/largest-flagpole

from pwn import *
import time

io = remote("largest-flagpole.hsctf.com", 1337)
f = open("data.txt", "w")

T = io.recvline().decode()
f.write(T)
for _ in range(int(T)):
	S = io.recvline().decode()
	f.write(S)
	M = S.split()[1]
	for tmp in range(int(M)):
		f.write(io.recvline().decode())

print(io.recvline().decode())

f.close()

print("data collection complete")
time.sleep(10) # gives time to run Java code and get output
print("time to send over some data")
with open("out.txt", "r") as r:
	tmp = r.readlines()
	ans = ''.join(map(str, tmp))
	print(ans)
	io.send(ans)
	print(io.recvline().decode())
	print(io.recvline().decode())