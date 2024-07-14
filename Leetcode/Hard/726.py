# https://leetcode.com/problems/number-of-atoms/description/?envType=daily-question&envId=2024-07-14

class Solution:
    def countOfAtoms(self, s: str) -> str:
        def is_digit(c):
            return '0' <= c <= '9'
        
        def is_upper(c):
            return 'A' <= c <= 'Z'
        
        def is_lower(c):
            return 'a' <= c <= 'z'
        
        n = len(s)
        st = []
        idx = 0
        
        while idx < n:
            if s[idx] == '(':
                # start of formula group
                st.append((s[idx], 0))
                idx += 1
            elif s[idx] == ')':
                # end of formula group
                idx += 1
                coeff = 0 # represents coeff of this group
                while idx < n and is_digit(s[idx]):
                    coeff = coeff * 10 + int(s[idx])
                    idx += 1
                if coeff == 0:
                    coeff = 1
                
                tmp = []
                while st and st[-1][0] != '(':
                    name, cnt = st.pop()
                    cnt *= coeff
                    tmp.append((name, cnt))
                st.pop()  # removes end of group
                
                for name, cnt in tmp:
                    st.append((name, cnt))
            else:
                if idx + 1 < n and is_lower(s[idx + 1]): # continuation of chemical symbol, like Mg
                    name = s[idx] + s[idx + 1]
                    idx += 2
                else: # chemical symbol only one letter, like O
                    name = s[idx]
                    idx += 1
                
                amt = 0 # number of atoms in this specific section
                while idx < n and is_digit(s[idx]):
                    amt = amt * 10 + int(s[idx])
                    idx += 1
                if amt == 0:
                    amt = 1
                
                st.append((name, amt))
        
        # Reconstruct the result
        mp = {}
        for name, cnt in st:
            mp[name] = mp.get(name, 0) + cnt
        
        result = []
        for name, cnt in sorted(mp.items()):
            result.append(name)
            if cnt > 1:
                result.append(str(cnt))
        
        return ''.join(result)