# time complexity: O(n)
# space complexity: O(1)

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        freq = {}
        for char in s:
            freq[char] = freq.get(char, 0)+1
        
        result = ""

        # add characters in the custom order
        for char in order:
            if char in freq:
                result += char*freq[char]
                del freq[char]

        # add remaining characters that are not in `Order`
        for char in freq:
            result += char*freq[char]

        return result