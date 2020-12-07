# Time Complexity:- O(n)
# Space Complexity:- O(n)
# Approach:- Maintain a dictionary over the window of elements we are seeing so far. If we encounter an element already seen before decrease the window to
# the element that was encountered before in our window.
class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        
        dict = {}
        
        start = max_length = 0
        
        for i in range(len(s)):
            if s[i] in dict and start <= dict[s[i]]:
                start = dict[s[i]]+1
            else:
                max_length = max(max_length, i-start+1)
            
            dict[s[i]] = i
        
        return max_length