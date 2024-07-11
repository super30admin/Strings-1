# Time Complexity:
# O(n) , n = lenght of string

# Space Complexity:  
# O(1)  

# Approach: 
# Use the hashmap, to maintain the index of the chars in the longest substring between the two pointers we will take.
# "start" pointer is the start of substr
# "i" is the end pointer of current substr under consideration

class Solution(object):      #Tc ==> O(n), Sc ==> O(1)
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s or len(s) == 0:
            return 0

        maxSubStr = 0    # return this as answer (length of longest substring)
        start = 0
        hashMap = {}   # store the char(key) and index(value)

        for i in range(len(s)):
            currChar= s[i]
            if currChar in hashMap.keys():
                # update the "start" pointer
                start = max(start, hashMap[currChar]+1)

            # update the size of longest substring untill now(i.e between "start" and "i" index)
            maxSubStr = max(maxSubStr, i-start+1)
            
            # update the index of currChar
            hashMap[currChar] = i
        
        return maxSubStr
