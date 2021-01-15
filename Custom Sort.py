# Time: O(T.length + S.length) | Space: O(T.length)

class Solution:
    def customSortString(self, S: str, T: str) -> str:
        counts = collections.Counter(T)
        result = []
        for ch in S:
            if ch in counts:
                result += [ch * counts[ch]]
                counts[ch] = 0
        for ch in counts:
            if counts[ch] != 0:
                result += [ch * counts[ch]]
        return ''.join(result)