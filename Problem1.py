# TC = O(m+n) | SC = O(1)

class Solution:
    def __appendResult(self, result: list[chr], char: chr, freq: int):

        while (freq > 0):
            result.append(char)
            freq -= 1
        return

    def customSortString(self, order: str, s: str) -> str:
        charFreqMap = {}
        for char in s:
            if char in charFreqMap:
                charFreqMap[char] += 1
            else:
                charFreqMap[char] = 1

        result = []

        for char in order:
            if char in charFreqMap:
                self.__appendResult(result, char, charFreqMap[char])
                del charFreqMap[char]

        for char in charFreqMap:
            self.__appendResult(result, char, charFreqMap[char])

        return ''.join(result)