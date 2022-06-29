'''
time complexity: O(m+n)
where m and n are len of str1 and str2

space complexity: O(1)
'''
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        scount = {}
        for i in range(len(s)):
            if s[i] not in scount:
                scount[s[i]]=0
            scount[s[i]]+=1
        res = ""
        for i in range(len(order)):
            if order[i] in scount:
                res+=order[i]*scount[order[i]]
                del scount[order[i]]
        
        for key,val in scount.items():
            res+=key*val
        return res