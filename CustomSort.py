#Time Complexity : O(n)
#Sapce Complexity : O(n)

from collections import defaultdict
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        charCount = defaultdict(int)
        for char in s:
            charCount[char] += 1
        print(charCount)
        result = []
        for char in order:
            if(char in charCount):
                count = 0
                for i in range(charCount[char]):
                    result.append(char)
                del charCount[char]
        for key, value in charCount.items():
            count = 0
            while(count < value):
                result.append(key)
                count += 1
        return "".join(result)
