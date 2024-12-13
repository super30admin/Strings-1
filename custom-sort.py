# The customSortString method sorts a string `s` based on the order defined by `order`.

# Count the occurrences of characters in `s` using a dictionary.
# Append characters from `order` to the result based on their counts in the dictionary.
# Add remaining characters in `s` (not in `order`) to the result.

# TC: O(m + n) - m is the length of `s`, n is the length of `order`.
# SC: O(m) - Space for the dictionary.


class Solution:
    def customSortString(self, order: str, s: str) -> str:
        result = ""
        mp = {}
        for char in s:
            mp[char] = mp.get(char, 0) + 1
        for char in order:
            if char in mp:
                result += char * mp[char]
                del mp[char]
        for char, count in mp.items():
            result += char * count
        return result