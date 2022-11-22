#Problem: https://codeforces.com/contest/525/problem/A

input()
house = input()
ans = 0
key = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
for i in range(len(house)):
    if ord(house[i]) >= 97:
        key[ord(house[i]) - 97] += 1
    else:
        if key[ord(house[i]) - 65] > 0:
            key[ord(house[i]) - 65] -= 1
        else:
            ans += 1
print(ans)
