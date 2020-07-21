# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
# Longest substring without repition of characters in a string.

# Brute foce : Time = O(n^2) | Space = O(26) = O(1) as map will have maximum of 26 characters.
class Solution:
    # def lengthOfLongestSubstring(self, str):
    #     if len(str) == 0 :
    #         return 0
    #     count = float('-inf')
    #     for i in range(len(str)):
    #         temp = 1
    #         map_ = {}
    #         map_[str[i]] = 1 
    #         for j in range(i+1, len(str)):
    #             if str[j] not in map_:
    #                 temp += 1 
    #                 map_[str[j]] = 1 
    #             else:
    #                 break 
    #         count = max(count, temp)
    #     return count

    # Time = O(n) | Space = O(26) = O(1) 
    def lengthOfLongestSubstring(self, str):
        if len(str) == 0:
            return 0 
        count = 0 
        slow, fast = 0, 0 
        _map = {}
        while fast < len(str):
            
            if str[fast] in _map:
                slow = max(slow, _map[str[fast]] + 1)
            
            count = max(count, fast - slow + 1)
            _map[str[fast]] = fast 
            fast += 1 
        
        return count 
    
if __name__ == "__main__":
    s = Solution()
    # Test Case 1 
    res = s.lengthOfLongestSubstring("abcabcbb")
    print(res)