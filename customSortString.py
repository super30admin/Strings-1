class Solution:
    #Time Complexity : O(M+N)
    #space Complexity : O(1)

    def customSortString(self, order: str, s: str) -> str:
        if not s or len(s) == 1:
            return s

        counter = {}

        for char in s:
            if char not in counter:
                counter[char] = 1
            else:
                counter[char] += 1
        result = ''

        for char in order:
            if char in counter:
                result += char * counter[char]
                del counter[char]

        for k, v in counter.items():
            result += (k * v)
        return result
