class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        res = 0
        tstr1 = ""
        hashMap = {}
        slow = 0
        for i in range(len(s)):
            if s[i] not in hashMap:
                hashMap[s[i]] = i
                
            else:
                '''
                The following code snippet is if we want to return the resulting string alongwith the count
                fast = i
                tstr = ""
                for x in range(slow,fast):
                        tstr += s[x]
                tstr1 = tstr1 if len(tstr1) > len(tstr) else tstr    
                '''
                slow = max(slow, hashMap[s[i]]+1)
                hashMap[s[i]] = i
            res = max(res, (i - slow+1))
        #print(tstr1) prints the resulting teststring
        return(res)
        

#Time complexity O(N)
#Space complexity O(1)