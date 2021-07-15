# 3. Longest Substring Without Repeating Characters

# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: all test cases passed
# Any problem you faced while coding this: No

# Approach: Sliding window approach; Data Structure: Hashmap

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        #
        # use of slow and fast pointers
        # slow pointer takes the first index of the occurence and the fast pointer 
        # traverses forward until a repeated character is found
        if len(s) == 1:
            return 1
        
        slow = 0 
        fast = 0
        dict_occurr = {}
        max_num = 0
        count = 0
        
        while(fast < len(s)):
            
            if not s[fast] in dict_occurr:
                dict_occurr[s[fast]] = fast
                fast=fast+1
                count = count+1
            else:
                if dict_occurr[s[fast]] < slow:
                    dict_occurr[s[fast]] = fast
                    # slow = fast
                    fast+=1
                    count+=1
                    
                else:
                    slow = dict_occurr[s[fast]] + 1
                    dict_occurr[s[fast]] = fast
                    fast+=1
                    if count > max_num:
                        max_num = count
                    count = fast-slow
        if count > max_num:
            max_num = count
        return max_num