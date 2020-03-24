# Runs on leetcode
# Time: O(n)
# Space: O(n)

# approach: sliding window. For each element of the right pointer, add element at right pointer to dictionary. While the
# element at the right pointer has frequency greater than or equal (equal also works) to 2, remove the element at the
# left pointer and increment the left pointer. We only need to check the right pointer because that is the only element
# whose frequency will increase and then we remove the left pointer element till that repeated element is removed,
# we don't need to check for left <= right because the frequency will become 1 at left < right at worst.
# After removing the repeated element, we are left with a string that can be our answer, the length of this
# is right - left + 1. Compare that with global max.

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        freq_dict = {}
        left = 0
        max_len = 0

        for right in range(len(s)):
            freq_dict[s[right]] = freq_dict.get(s[right], 0) + 1

            while freq_dict[s[right]] >= 2:
                freq_dict[s[left]] -= 1
                left += 1

            max_len = max(max_len, right - left + 1)

        return max_len