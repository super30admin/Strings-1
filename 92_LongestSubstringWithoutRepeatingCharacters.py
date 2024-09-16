'''
Accepted on leetcode(3)
time - O(N) , space O(1)

'''
import collections
class Solution:
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        # edge case
        if s is None or len(s) == 0: return 0
        # Declaring variables
        arr = collections.defaultdict(int)
        slow = 0
        fast = 0
        maxi = 0
        # iterate over the string
        while fast < len(s):
            # Add the characters to hashmap with their index +1 as value
            if arr[s[fast]] > 0:
                # move the slow pointer
                slow = max(slow, arr[s[fast]])
            arr[s[fast]] = fast + 1
            # length of longest substring is calculated
            maxi = max(maxi,fast-slow+1)
            # increment fast pointer
            fast += 1
        return maxi