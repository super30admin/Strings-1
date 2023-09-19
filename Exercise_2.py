# Problem2
# Longest Substring Without Repeating Characters(https://leetcode.com/problems/longest-substring-without-repeating-characters/)
# // Time Complexity :O(2n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach
# Hashset Approach
class Solution:
    def lengthOfLongestSubstring(self, s):
        # creating a hashset of all uniques
        uniques = set()
        slow = 0
        length = 0
        # iterating over the string
        for i in range(len(s)):
            # till the char is in the set
            while s[i] in uniques:
                # we remove it
                uniques.remove(s[i])
                # update slow ptr
                slow += 1
            uniques.add(s[i])
        length = max(length, len(uniques))
        return length


sol = Solution()
print(sol.lengthOfLongestSubstring("abcabcbb"))
