'''
Did it run on leetcode: Yes
Time Complexity: 0(N)
Space Complexity: 0(1)

Algorithm:
- slow and fast pointers where will increment till not a repeating is encounterd
- indexes will be stored in array
- fast-slow will give us the length

'''

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        maxLen=0
        if not s:
            return maxLen 
        arr = [0 for _ in range(256) ]
        slow,fast =0,0
        
        
        while fast<len(s):
            if arr[ord(s[fast])]>0:
                slow = max(slow,arr[ord(s[fast])])
                
                
            arr[ord(s[fast])] = fast+1
            maxLen = max(maxLen,fast-slow+1)
            fast+=1
        return maxLen
        