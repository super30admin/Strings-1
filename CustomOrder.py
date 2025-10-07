#Time complexity: O(n+m), iterating through s to create the freq map and then iterating through order to get all the freq and appending into the result
#Space complexity: O(1) at most the freq map can have 26 letters

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        freq = Counter(s)
        result = []
        for c in order:
            cnt = freq[c]
            for _ in range(cnt):
                result.append(c)
            del freq[c]
        for key, val in freq.items():
            for _ in range(val):
                result.append(key)
        return "".join(result)