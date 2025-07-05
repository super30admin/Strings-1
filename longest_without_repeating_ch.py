# Approach (Sliding Window + HashSet):
# -------------------------------------
# 1. Use two pointers `i` and `j` to define a sliding window of unique characters.
# 2. Initialize a set to store characters in the current window.
# 3. Iterate `j` over the string:
#    - If `s[j]` is already in the set (duplicate), remove `s[i]` from the set and move `i` forward.
#    - Else, add `s[j]` to the set and update the `count` as the max of current count and window size (j - i + 1).
# 4. Return the max count found.

# Time Complexity: O(2 * n), where n = length of string
# - Each character is visited at most twice (once added, once removed)

# Space Complexity: O(1) space for hashset will maximum be 26 alphabets
class Solution:
    def lengthOfLongestSubstring(self, s):
        i, count  = 0, 0
        hashset = set()
        for j in range(len(s)):
            while s[j] in hashset:
                hashset.remove(s[i])
                i += 1
            hashset.add(s[j])
            count = max(count, j-i+1)
        return count

def main():
    sol = Solution()

    print("Test Case 1:")
    print("Length:", sol.lengthOfLongestSubstring("abcabcbb"))  # Expected: 3

    print("\nTest Case 2:")
    print("Length:", sol.lengthOfLongestSubstring("bbbbb"))  # Expected: 1

    print("\nTest Case 3:")
    print("Length:", sol.lengthOfLongestSubstring("pwwkew"))  # Expected: 3

    print("\nTest Case 4:")
    print("Length:", sol.lengthOfLongestSubstring(""))  # Expected: 0

    print("\nTest Case 5:")
    print("Length:", sol.lengthOfLongestSubstring("dvdf"))  # Expected: 3

if __name__ == "__main__":
    main()