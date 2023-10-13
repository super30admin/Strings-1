#TC: O(M+N) M and N are lengths of strings
#SC: O(1)

class CustomSortString:

    def __appendResult(self, result: List[chr], char: chr, freq: int):

        while (freq > 0):
            result.append(char)
            freq -= 1
        return

    def customSortString(self, S: str, T: str) -> str:

        charFreqMap = {}
        for char in T:
            if char in charFreqMap:
                charFreqMap[char] += 1
            else:
                charFreqMap[char] = 1

        result = []

        for char in S:
            if char in charFreqMap:
                self.__appendResult(result, char, charFreqMap[char])
                del charFreqMap[char]

        for char in charFreqMap:
            self.__appendResult(result, char, charFreqMap[char])

        return ''.join(result)