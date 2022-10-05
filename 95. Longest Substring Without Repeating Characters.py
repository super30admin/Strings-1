# Time Complexity: O(n)
# Space Complexity: O(1)

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hashset = []
        slow, fast = 0, 0
        max_length = 0
        while fast != len(s):
            new = s[fast]
            if new in hashset:
                while(new in hashset):
                    hashset.remove(s[slow])
                    slow += 1    
            hashset.append(new)
            fast += 1
            max_length = max(max_length, len(hashset))
            
        return max_length