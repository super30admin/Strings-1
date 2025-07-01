"""
I implemented both HashSet and HashMap approaches. However, the HashMap version is more efficient because it reduces the number of operations by allowing the left pointer to jump directly to the next valid position instead of moving step by step. I used the sliding window technique in both versions. In the HashMap approach, I tracked the last seen index of each character, enabling us to skip unnecessary iterations.
Time Complexity: O(n)
Space Complexity: O(1)
"""
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # #using hashset
        # hashSet = set()
        # left = ans = 0
        # for right in range(len(s)):
        #     while s[right] in hashSet:
        #         hashSet.remove(s[left])
        #         left += 1
        #     hashSet.add(s[right])
        #     ans = max(ans, right - left + 1)
        # return ans
        #using hashmap
        hashMap = {}
        left = ans = 0
        for right in range(len(s)):
            if s[right] in hashMap and hashMap[s[right]] >= left:
                left = hashMap[s[right]] + 1
            hashMap[s[right]] = right
            ans = max(ans, right - left + 1)
        return ans