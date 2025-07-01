# ----------------------------------------------------
# Intuition:
# Brute Force:
# - For each character in 'order', iterate over 's' and append matching characters.
# - Then append characters from 's' that do not appear in 'order'.
# - Inefficient due to repeated scans: O(m*n), where m = len(order), n = len(s).
#
# Optimized Approach:
# - Count frequency of each character in 's' using a hashmap.
# - Append characters in the order given by 'order', using the frequency map.
# - Append any remaining characters from 's' that do not appear in 'order'.
# - This results in an efficient O(m + n) time solution.
# ----------------------------------------------------

# ----------------------------------------------------
# Brute Force Time & Space:
# Time Complexity: O(m * n)
# - For each character in 'order' (m characters), we scan through the entire string 's' (n characters) 
#   to find matching characters. This leads to a nested iteration resulting in O(m * n) time.
#
# Space Complexity: O(n)
# - We store the output list which contains all characters of 's', hence O(n).
# ----------------------------------------------------

# ----------------------------------------------------
# Optimal Approach Time & Space:
# Time Complexity: O(m + n)
# - We first count frequencies of all characters in 's' in one pass: O(n).
# - Then we iterate over 'order' once (m characters) to append characters in the desired order.
# - Finally, we append the remaining characters in 's' (not in 'order') once.
# - Overall, this results in linear time relative to input sizes.
#
# Space Complexity: O(n)
# - We use a frequency dictionary that stores counts for characters in 's', which can be at most O(n) in size.
# - We also create the output list containing all characters, so total extra space is O(n).
# ----------------------------------------------------

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        # Edge case
        if not s:
            return ""
        if not order:
            return s
        
        freq_map = {}
        res = []

        # Count frequency of each character in s
        for ch in s:
            freq_map[ch] = freq_map.get(ch, 0) + 1

        # Append characters in the custom order
        for ch in order:
            if ch in freq_map:
                res.append(ch * freq_map[ch])
                del freq_map[ch]

        # Append remaining characters not in order
        for ch, count in freq_map.items():
            res.append(ch * count)

        return "".join(res)

"""
# Brute Force Approach:

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        # Edge case
        if not s:
            return ""
        if not order:
            return s

        res = []
        for ch in order:
            for c in s:
                if c == ch:
                    res.append(c)

        order_set = set(order)
        for c in s:
            if c not in order_set:
                res.append(c)

        return "".join(res)
"""

if __name__ == "__main__":
    sol = Solution()

    print(sol.customSortString("cba", "abcd"))      # Expected: "cbad" or similar
    print(sol.customSortString("bcafg", "abcd"))    # Expected: "bcad" or similar
    print(sol.customSortString("", "abc"))          # Expected: "abc"
    print(sol.customSortString("abc", ""))          # Expected: ""
    print(sol.customSortString("xyz", "zxyxxyz"))   # Expected: "xxyyzz"

