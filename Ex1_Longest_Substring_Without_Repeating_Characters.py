# ----------------------------------------------------
# Intuition:
# We're asked to find the longest substring without repeating characters.
#
# 1. Brute Force:
#    Try all possible substrings and check if all characters are unique.
#    → Inefficient: O(n^3)
#
# 2. Sliding Window with Set:
#    Use two pointers to represent a window and a set to track unique characters.
#    If duplicate is found, shrink the window from the left.
#    → Better: O(2n)
#
# 3. Optimal Approach (Sliding Window + HashMap):
#    Track last seen index of each character using a hashmap.
#    When duplicate is found, jump the left pointer directly to skip repeated part.
#    → Most efficient: O(n)
# ----------------------------------------------------

# ----------------------------------------------------
# Optimal Approach: Sliding Window + HashMap
#
# Time Complexity: O(n)
# - Each character is visited at most twice.
#
# Space Complexity: O(min(n, m))
# - m is the character set size (e.g., 128 for ASCII)
# ----------------------------------------------------

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        #Edge case
        if not s:
            return 0
        
        index_map = {}
        max_len = 0
        left = 0
        
        for right in range(len(s)):
            char = s[right]
            if char in index_map and index_map[char] >= left:
                left = index_map[char] + 1
            index_map[char] = right
            max_len = max(max_len, right - left + 1)
        
        return max_len

# ----------------------------------------------------
# Sliding Window Using Set (Slightly Less Optimal)
#
# Time Complexity: O(2n)
# Space Complexity: O(min(n, m))
# ----------------------------------------------------

# class Solution:
#     def lengthOfLongestSubstring(self, s: str) -> int:
#         char_set = set()
#         left = 0
#         max_len = 0
#         
#         for right in range(len(s)):
#             while s[right] in char_set:
#                 char_set.remove(s[left])
#                 left += 1
#             char_set.add(s[right])
#             max_len = max(max_len, right - left + 1)
#         
#         return max_len

# ----------------------------------------------------
# Brute Force Approach
#
# Time Complexity: O(n^3)
# Space Complexity: O(n)
# ----------------------------------------------------

# class Solution:
#     def lengthOfLongestSubstring(self, s: str) -> int:
#         def all_unique(sub):
#             return len(set(sub)) == len(sub)
#         
#         n = len(s)
#         max_len = 0
#         for i in range(n):
#             for j in range(i + 1, n + 1):
#                 if all_unique(s[i:j]):
#                     max_len = max(max_len, j - i)
#         return max_len

# ----------------------------------------------------
# Example Usage:
if __name__ == "__main__":
    sol = Solution()
    print(sol.lengthOfLongestSubstring("abcabcbb"))  # Output: 3
    print(sol.lengthOfLongestSubstring("bbbbb"))     # Output: 1
    print(sol.lengthOfLongestSubstring("pwwkew"))    # Output: 3
    print(sol.lengthOfLongestSubstring(""))          # Output: 0
    print(sol.lengthOfLongestSubstring("au"))        # Output: 2
