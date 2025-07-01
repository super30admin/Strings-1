# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        count = Counter(s)
        result = []
        # Add characters in the order specified by 'order'
        for char in order:
            if char in count:
                result.append(char * count[char])
                del count[char]
        # Add the remaining characters not in 'order'
        for char, freq in count.items():
            result.append(char * freq)
        return ''.join(result)
        