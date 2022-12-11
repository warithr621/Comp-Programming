# AoC 2022 D11

import sys

monkey = [[], [], [], [], [], [], [], []]
inspect = [0, 0, 0, 0, 0, 0, 0, 0]
operations = []
li = open("input.txt", "r").readlines()
i = 0
cur = -1

def inter(s):
    return int(s.replace(',', ''))

while i < len(li):
    s = li[i]
    a = s.split()
    if a[0] == 'Monkey':
        cur += 1
        i += 1
        continue
    
    for j in range(2, len(a)):
        monkey[cur].append(inter(a[j]))
    
    op = ""
    i += 1
    s = li[i]
    a = s.split()
    for j in range(2, len(a)):
        op += a[j]
    
    mod = inter(li[i+1].split()[3])
    orig = inter(li[i+2].split()[5])
    fin = inter(li[i+3].split()[5])
    
    operations.append([op[1:], mod, orig, fin])
    
    i += 5
        
# print(monkey)
# print(operations)

for round in range(20):
    for i in range(8):
        while len(monkey[i]) != 0:
            inspect[i] += 1
            old = monkey[i][0]
            # print(old)
            new = eval(operations[i][0]) // 3
            # print(new)
            monkey[operations[i][2 if new % operations[i][1] == 0 else 3]].append(new)
            monkey[i].pop(0)
    
    # print(monkey)
            
inspect.sort()
print(inspect[-1] * inspect[-2])