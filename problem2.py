#Time Complexity :O(n)
#Space Complexity :O(1) Hashmap will be of size atmost 26
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hashmap = dict()
        max_count = 0
        
        slow = 0
        fast = 0
        
        while fast < len(s):
            if s[fast] not in hashmap:
                hashmap[s[fast]] = fast
            else:
                index = hashmap[s[fast]]
                if slow <= index < fast:
                    slow = hashmap[s[fast]] + 1
                hashmap[s[fast]] = fast
            
            max_count = max(max_count, fast-slow+1)
            fast += 1
        return max_count