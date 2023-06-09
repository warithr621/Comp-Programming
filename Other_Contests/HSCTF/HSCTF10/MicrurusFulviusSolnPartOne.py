# HSCTF10 rev/micrurus-fulvius

import itertools

characters = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_!@#$%^&*(){}/|><.'

# Generate all possible 2-character strings
possible_strings = [''.join(pair) for pair in itertools.product(characters, repeat=2)]

a = dict()

def collatz(n):
    b = 0
    orig = n
    while n != 1:
        if a.get(n) == None:
            if n & 1:
                n = 3*n + 1
            else:
                n //= 2
            b += 1
        else:
            a[orig] = a[n] + b
            return a[orig]
    a[orig] = b
    return a[orig]
    
for i in range(1, 18000):
    collatz(i)

l = [-153,462,438,1230,1062,-24,-210,54,2694,1254,69,-162,210,150]

# d( a( j(*c) - 10), i) * 3 == l[i]

for i in range(len(l)):
    cur = l[i] // 3
    cur += 158
    cur >>= (i % 5)
    # at this point, cur = a(j(*c) - 10)
    works = [] # list of strings that work
    for ST in possible_strings:
        tmp = ord(ST[0]) * 115 + ord(ST[1]) * 21
        tmp -= 10
        tmp = a[tmp]
        if tmp == cur:
            works.append(ST)
    print(works)
    