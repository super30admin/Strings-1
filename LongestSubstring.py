# Time Complexity: O(2n) -> O(n) as we are iterating through the string once and then another time while removing the value from hashset
# Time complexity: O(1) as there are only be constant elements in the hashset. Doesn't increase with the increase in size of the array

# The intuition is to use a sliding technique window and once we find dups, then move the left pointer.

class Solution:
    def lengthOfLongestSubstringSet(self, s: str) -> int:
        left = 0
        hashset = set()
        longest = 0
        for i in range(len(s)):
            if s[i] in hashset:
                while s[left] != s[i]:
                    hashset.remove(s[left])
                    left += 1
                left += 1
            hashset.add(s[i])
            longest = max(longest, i - left + 1)

        return longest

    # This solution is using hashmap instead of hashset. The time complexity is true O(n) as compared to the hashset solution

    def lengthOfLongestSubstringMap(self, s: str) -> int:
        left = 0
        hashmap = {}
        longest = 0
        for i in range(len(s)):
            if s[i] in hashmap:
                idx = hashmap[s[i]]
                if idx + 1 > left:
                    left = idx + 1
            hashmap[s[i]] = i
            longest = max(longest, i - left + 1)

        return longest