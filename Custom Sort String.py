# time complexity is o(m + n), where m,n is the size of the input, m is size of order and n is the size of the s.
# space complexity is o(n), where n is the size of the input.
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        d = dict() # space is o(26), which is constant o(1)
        res = list() # space is o(n)
        for i in s: # time o(n)
            if(i not in d):
                d[i] = 0
            d[i] += 1
        for i in order: # time o(m)
            if(i in d):
                while(d[i] > 0):
                    res.append(i)
                    d[i] -= 1
                del d[i]
        for key in d:
            while(d[key] > 0):
                res.append(key)
                d[key] -= 1
        fs = ''.join(res)
        return fs
                
        