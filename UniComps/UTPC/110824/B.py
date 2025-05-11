keys = []
keyswblack = []
for i in range(1, 8):
    for c in "CDEFGAB":
        keys.append(c + str(i))
    for c in "C?D?EF?G?A?B":
        keyswblack.append(c + str(i))
keys.append("C8")
keyswblack.append("C8")
a,b = map(str, input().split())
tot = keys.index(b) - keys.index(a) + 1
other = keyswblack.index(b) - keyswblack.index(a) + 1
print(other - tot)