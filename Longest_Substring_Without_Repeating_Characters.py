from collections import Counter
#Longest Substring Without Repeating Characters
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        """
        Time Complexity: O(n)
        Space Complexity: o(1)
        """
        if s == '':
            return 0
        tup = [0,0]
        max_ = tup[1]-tup[0] + 1
        
        i = 0
        hash_ = {}
        
        while i < len(s):
            if hash_.get(s[i]) is None:
                hash_[s[i]] = i
                tup[1] = i
                max_ = max(max_,tup[1] - tup[0] + 1)
            else:
                tup[0] = max(tup[0],hash_[s[i]] + 1)
                tup[1] = i
                hash_[s[i]] = i 
                max_ = max(max_,tup[1] - tup[0] + 1)
            i += 1
        return max_
                
                
        

