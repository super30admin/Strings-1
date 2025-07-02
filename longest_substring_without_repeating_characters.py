class Solution:
    # def lengthOfLongestSubstring(self, s: str) -> int:
    #     """
    #     TC: O(n)
    #     AS: O(1)
    #     """
        
    #     hashset = set()
    #     n = len(s)

    #     left = 0
    #     right = 0
    #     maxLength = 0

    #     while (right < n):
    #         char = s[right]

    #         if char not in hashset:
    #             hashset.add(char)
    #         else:
    #             while (s[left] != char):
    #                 hashset.remove(s[left])
    #                 left += 1
    #             left += 1

    #         maxLength = max(maxLength, right - left + 1)
    #         right += 1
    #     return maxLength


    def lengthOfLongestSubstring(self, s: str) -> int:
        """
        TC: O(n)
        AS: O(1)
        """
        hashMap = {}
        n = len(s)

        left = 0
        right = 0
        maxLength = 0

        for right in range(n):
            char = s[right]

            if char in hashMap:
                left = max(left, hashMap[char] + 1)
                
            hashMap[char] = right
            maxLength = max(maxLength, right - left + 1)

        return maxLength
