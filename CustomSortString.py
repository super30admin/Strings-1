

'''
Solution:
1.  The main idea to this problem is maintain a HashMap of counts of characters of second string
    and push elements of first string to resultant string (count) number of times.
2.  Push remaining elements in HashMap (second string) in any order to the resultant string.
Time Complexity:    O(M+N) M and N -- lengths of strings
Space Complexity:   O(1)
---Passed all testcases on leetcode successfully.
'''

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hMap = {}
        result = ""
        #   fill in the frequencies of characters belonging to second array
        for c in s:
            if c in hMap:
                hMap[c] += 1
            else:
                hMap[c] = 1
      
        #   first add all elements of first string in the same order - (frequency) number of times         
        for c in order:
            if c in hMap:
                count = hMap[c]
                for i in range(count):
                    result += c
                del hMap[c]
        #   add remaining elements of HashMap to the list   
        for c in hMap:
            count = hMap[c]
            for i in range(count):
                result += c
        return result
            