# aa

class Solution:
    def isNumber(self, s: str) -> bool:
        s = s.strip()
        if not s:
            return False

        num, dot, e = False, False, False
        for i, c in enumerate(s):
            if c == '.':
                if dot or e:
                    return False
                dot = True
            elif c in 'eE':
                if e or not num:
                    return False
                e = True
                num = False
            elif c in '-+':
                if i > 0 and s[i-1] not in 'eE':
                    return False
                num = False
            else:
                if not c.isdigit():
                    return False
                num = True
        return num