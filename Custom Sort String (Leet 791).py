'''
Time: O(n)
Space: O(1), 26 alphabets
'''

class Solution:
    res = ''
    def customSortString(self, order: str, s: str) -> str:
        
        if s == '' or len(s) == 0:
            return ''
        
        hm = dict()
        
        for ch in s:
            if ch not in hm:
                hm[ch] = 0
            hm[ch] += 1
        
        self.res = ''

        for ch in order:
            if ch in hm:
                count = hm[ch]

                while count > 0:
                    self.res += ch
                    count -= 1
                del hm[ch]

        for ch in hm:
            count = hm[ch]
            while count > 0:
                self.res += ch
                count -= 1

        return self.res

        
        