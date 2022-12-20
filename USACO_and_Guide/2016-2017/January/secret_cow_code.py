# 2017 Jan Silver P3

fr = open("cowcode.in", "r")
fw = open("cowcode.out", "w")

def char_finder(s, n):
    if n < len(s):
        return s[n]
    L = len(s)
    while(L * 2 <= n):
        L *= 2
    if L == n:
        return char_finder(s, L-1)
    
    return char_finder(s, n - L - 1)
    

s, n = map(str, fr.read().split())
fw.write(char_finder(s, int(n)-1)) # first char is index 1 not 0
fr.close(); fw.close();