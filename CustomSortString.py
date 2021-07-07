'''
Solution:
1.  The main idea to this problem is maintain a HashMap of counts of characters of second string
    and push elements of first string to resultant string (count) number of times.
2.  Push remaining elements in HashMap (second string) in any order to the resultant string.

Time Complexity:    O(M+N) M and N -- lengths of strings
Space Complexity:   O(1)

---Passed all testcases on leetcode successfully.
'''


class CustomSortString:

    def __appendResult(self, result: List[chr], char: chr, freq: int):

        #   function to append character corresponding number of times to the list
        while (freq > 0):
            result.append(char)
            freq -= 1
        return

    def customSortString(self, S: str, T: str) -> str:

        #   fill in the frequencies of characters belonging to second array
        charFreqMap = {}
        for char in T:
            if char in charFreqMap:
                charFreqMap[char] += 1
            else:
                charFreqMap[char] = 1

        #   add characters to a list as string concatenation is costly
        result = []

        #   first add all elements of first string in the same order - (frequency) number of times
        for char in S:
            if char in charFreqMap:
                self.__appendResult(result, char, charFreqMap[char])
                del charFreqMap[char]

        #   add remaining elements of HashMap to the list
        for char in charFreqMap:
            self.__appendResult(result, char, charFreqMap[char])

        #   convert list to string and return
        return ''.join(result)