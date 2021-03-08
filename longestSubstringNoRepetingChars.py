#TimeComplexity:O(N) 
#SpaceComplexity: O(N) for dictionary
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        count=0
        dict1={}
        sol=0
        for i in range(len(s)):
            if s[i] not in dict1:
                count+=1
            elif i-dict1[s[i]]>count:
                count+=1
            elif i-dict1[s[i]]<count:
                sol=max(count,sol)
                count=i-dict1[s[i]]
            dict1[s[i]]=i
        return max(sol,count)
                