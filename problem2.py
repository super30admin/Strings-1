#Time Complexity : O(n)
#Space Complexity :O(1)
#Did this code successfully run on Leetcode : yes


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hash_set = set()
        slow = 0
        max_value = 0

        for c in s:
            if c in hash_set:
                while s[slow] != c:
                    hash_set.remove(s[slow])
                    slow += 1
                slow += 1
            else:
                hash_set.add(c)
            max_value = max(max_value, len(hash_set))
        
        return max_value