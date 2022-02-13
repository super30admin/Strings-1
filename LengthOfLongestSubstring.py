'''
Solution:
1.  The main idea of this problem is sliding window by maintaining two pointers representing
    slow and i(index) pointers of the possibly longest substring.
2.  The purpose of i(index) is to expand the substring by adding elements into the HashMap and the
    purpose of slow  is to shrink the substring whenever i(index) pointer is already present in HashMap.
3.  This shrinking happens until the end pointer element is not in HashMap.
Time Complexity:    O(N)    |   Space Complexity:   O(1)
--- Passed all testcases on Leetcode successfully.
'''

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        hMap = {}
        maximum = 0 
        slow = 0
        
        for i in range(len(s)):
            c = s[i]
            
            if c in hMap:
                slow = max(slow, hMap[c])
            
            hMap[c] = i+1
            maximum = max(maximum , i - slow + 1)
            
        return maximum