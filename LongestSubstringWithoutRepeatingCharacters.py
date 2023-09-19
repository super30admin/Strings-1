#Time Complexity : O(2n) = O(n) where n is the length of string
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :No

#Approach: We use set as a data structure to store the characters. We iterate through the string and add the characters into the set
# if not present already. If the character is present in the set, we remove that character and we move the slow pointer +1 until 
# we pass reach the same character in the set which is repeated. We also find the max length at reach iteration which corresponds
# to the length of the set. We return max length.

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        slow = 0
        maxl = 0
        charset = set()
        for i in range(len(s)):
            inn = s[i]
            if inn in charset:
                while s[slow] != inn:
                    charset.remove(s[slow])
                    slow += 1
                slow += 1
            else:
                charset.add(s[i])
            maxl = max(maxl, len(charset))
        return maxl