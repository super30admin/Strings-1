# Time Complexity : O(N) 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        start=0
        end=0
        hset=set()
        maxLength=0
        if len(s)==0:
            return 0
        while(start<=end):
            if(s[end] in hset):
                hset.remove(s[start])
                start+=1
                
            else:
                hset.add(s[end])
                if end<len(s)-1:
                    end+=1
                maxLength=max(maxLength,len(hset))
        return maxLength
        
solution =  Solution()
print(f'OUTPUT >> {solution.lengthOfLongestSubstring("pwwkew")}')