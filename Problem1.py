'''
1. First maintain a hashMap of frequency of each character in the string.
2. Iterate over the order string and append the character to the result string as many times as the frequency of the character in the hashMap.
3. Delete the key that was dealt. Now the hashMap contains only the characters that are not in the order string. Iterate append the remaining characters to the result string.

TC: O(n) where n is the length of the string.
SC: O(1) as there are only lower case letters.
'''

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        if not s or len(s) == 0:
            return s
        
        freqs = {}
        res = []
        for i in range(len(s)):
            c = s[i]
            if c not in freqs:
                freqs[c] = 1
            else:
                freqs[c] += 1
            
        for i in range(len(order)):
            c = order[i]
            if c in freqs:
                for j in range(freqs[c]):
                    res.append(c)
                del freqs[c]

        for key,val in freqs.items():
            for i in range(val):
                res.append(key)
        
        return "".join(res)
        