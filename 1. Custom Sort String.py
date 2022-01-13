from collections import Counter
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        # Time Complexity = O(m+n) where 'm' chars in order and 'n' chars in s
        # Space Complexity = O(1) as there are only 26 alphabets. So, constant space
        if s is None or len(s) == 0:
            return ""

        counts = Counter(s)

        result = ""
        for char in order:
            result += (char * counts[char])
            del counts[char]

        for char, count in counts.items():
            result += (char * counts[char])

        return result