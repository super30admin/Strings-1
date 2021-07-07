'''
Solution:
1.  The main idea of this problem is sliding window by maintaining two pointers representing
    start and end pointers of the possibly longest substring.
2.  The purpose of end is to expand the substring by adding elements into the HashSet and the
    purpose of start is to shrink the substring whenever end pointer is already present in HashSet.
3.  This shrinking happens until the end pointer element is not in HashSet.

Time Complexity:    O(N)    |   Space Complexity:   O(1)

--- Passed all testcases on Leetcode successfully.
'''


class LongestSubstring:
    def lengthOfLongestSubstring(self, s: str) -> int:

        #   edge case check
        if (s == None or len(s) == 0):
            return 0

        #   initializations
        maxLength = 0
        start = 0
        end = 0
        elementsPresent = set()

        #   until end pointer hits the end
        while (end < len(s)):

            #   until end pointer element is removed from HashSet -- multiple presence of element can be there
            while (s[end] in elementsPresent):
                elementsPresent.remove(s[start])
                start += 1

            elementsPresent.add(s[end])                     #   add the end pointer element to the HashSet
            maxLength = max(maxLength, end - start + 1)     #   check whether current length exceeds already max length
            end += 1                                        #   increment end pointer and continue iterating

        #   return final maximum length
        return maxLength                    