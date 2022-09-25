# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        #hashset = [False]*128
        hashset =set()
        start =0
        maximum = 0
        
        for end in range(len(s)):
            #if hashset[ord(s[end])] == False:
            if s[end] not in hashset:
                #hashset[ord(s[end])] =True
                hashset.add(s[end])
                maximum = max(maximum,end-start+1)
                #print(start,end)
                
                
            else:
                while s[start] != s[end]:
                    #hashset[ord(s[start])] =False
                    hashset.remove(s[start])
                    start+=1
                start+=1
        return maximum