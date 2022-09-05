# https://codeforces.com/contest/955/problem/B

s = input()
n = len(s)

freq = [0] * 26
for i in range(n):
    freq[ord(s[i]) - ord('a')] += 1
    
unique = 0
cnt = [0, 0, 0]
for i in range(26):
    if freq[i] > 0:
        unique += 1
        if freq[i] == 1:
            cnt[1] += 1
        else:
            cnt[2] += 1

if unique <= 1 or unique >= 5:
    print("No")
elif unique == 4:
    print("Yes")
elif unique == 3 and cnt[2] >= 1:
    print("Yes")
elif unique == 2 and cnt[2] >= 2:
    print("Yes")
else:
    print("No")