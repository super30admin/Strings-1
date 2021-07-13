# Time Complexity: O(n)
# Space Complexity: O(1)
from collections import defaultdict


class Solution:
    #     starting one pointer at the start of an array and we will iterate over
    #     the string and check if the element is in hashmap if not we will add it with element
    #     and its index + 1 and if already present then we will move our pointer to the max of start pointer
    #     and index stored of that element in the hashmap
    #     we will get the maximum of max element and range of current index and start pointer
    def lengthOfLongestSubstring(self, s) :
        hmap = defaultdict()
        low = 0
        maxe = 0

        for i in range(len(s)):
            if s[i] in hmap:
                low = max(low, hmap[s[i]])

            maxe = max(maxe, i - low + 1)
            hmap[s[i]] = i + 1

        return maxe

