# https://codeforces.com/contest/1999/problem/D

def solve(s, t):
    t_len = len(t)
    t_pointer = 0
    
    result = []
    
    for char in s:
        if char == "?":
            if t_pointer < t_len:
                result.append(t[t_pointer])
                t_pointer += 1
            else:
                result.append('a')  # Use any default character if all of t is already used
        elif t_pointer < t_len and char == t[t_pointer]:
            result.append(char)
            t_pointer += 1
        else:
            result.append(char)
    
    if t_pointer < t_len:
        return "NO" # why cant i read problem properly
    
    return "YES\n" + "".join(result)

for _ in range(int(input())):
    s = input()
    t = input()
    print(solve(s, t))