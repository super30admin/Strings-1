# time O(N)
# space O(N)

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        l=0
        strr=""
        for i in s:
            if i in list(strr):
                # print(strr,i,strr.index(i))
                inn=strr.index(i)
                strr=strr[inn+1:]
            strr+=i
            l=max(l,len(strr))
        return l
