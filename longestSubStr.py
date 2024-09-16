#leetcode 3: successfull
#Time Complexity : O(n) Space Com : O(1)
#Steps:
#1) create hasmap to store the indices of the chars encountered
#2) if the char repeats,update the slow ptr
#3) update the map indices for every char encountered
#4) keep updating the length

import collections
class Solution:
    def lengthOfLongestSubstring(self, s):
        #edge case
        if s==None or len(s)==0:
            return 0
        #1
        map = collections.defaultdict(int)
        slow=0
        fast=0
        longest=0

        while fast < len(s):
            #2
            if map[s[fast]] > 0:
                slow = max(map[s[fast]], slow)
            #3
            map[s[fast]] = fast+1
            #4
            longest = max(longest,fast-slow+1)
            fast +=1
        return longest
obj = Solution()
print(obj.lengthOfLongestSubstring("abcabpqr"))
