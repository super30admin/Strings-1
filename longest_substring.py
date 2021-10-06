# // Time Complexity :O(n), sliding window
# // Space Complexity :O(1), 26 characters stored in hashmap max
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach



class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        slow=0
        hmap={}
        maxx=0
        for i in range(len(s)):
            
            if s[i] not in hmap.keys():
                hmap[s[i]]=i+1
            else:
                slow=max(hmap[s[i]],slow)
                hmap[s[i]]=i+1

           
          
            if (i - slow + 1) > maxx:
                maxx=i-slow+1
               
        return maxx