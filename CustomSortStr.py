# Time Complexity: O(m+n) where m is order len and n is s len - Counting O(n) + Going through order O(m)
# Space Complexity: O(1)
from collections import Counter
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        freq = Counter(s)

        result = []
        for ch in order:
            if ch in freq:
                result.append(ch*freq[ch])
                del freq[ch]
        
        for ch, count in freq.items():
            result.append(ch*count)

        return ''.join(result)