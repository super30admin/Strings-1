# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hash_set = set()
        slow = 0
        n = len(s)
        max_val = 0
        for i in range(n):
            c = s[i]
            if c in hash_set:
                while c != s[slow]:
                    hash_set.remove(s[slow])
                    slow += 1
                slow += 1
            hash_set.add(c)
            max_val = max(max_val, i - slow + 1)

        return max_val
