bits = [
    "000 000 001 110 000 110 001 000 100 101",
    "001 011 100 100 001 100 100 110 101 100",
    "001 010 000 100 110 011 110 000 011 011",
    "100 101 100 101 110 010 101 100 111 011",
    "010 000 110 011 011 000 111 110 011 110",
    "010 100 101 111 001 011 101 101 000 111",
    "010 011 000 011 010 001 100 011 110 001",
    "101 001 111 011 101 101 110 010 011 001",
    "010 111 010 000 111 110 011 000 000 111",
    "001 011 111 011 101 011 011 111 001 101"
]
# time to read bits by column, rather than row...
s = ""
for j in range(0, 39, 4):
    for i in range(10):
        # i = row number, j = col (4-wide)
        s += bits[i][j:j+3] # pick up 3 characters (4th character is space)
s = s[4::] # remove 4 padding zeros at start

# lastly, convert the string to ASCII!
x = int('0b' + s, 2)
# .to_bytes(# of bytes = # of bits / 8 rounded up, byte order = most significant first)
print(x.to_bytes((x.bit_length() + 7) // 8, 'big').decode())
# there might've been a more efficient way to do this, but it's solved regardless :D