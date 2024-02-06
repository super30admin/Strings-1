'''

Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach

Using a hashmap to store the index of the element which have occurred previously. As I loop thru the list, a variable is maintained to track
the maximum length formed without repitions

'''

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        char = defaultdict(int)

        i = j = 0
        length = 0

        while j < len(s):
            if s[j] in char:
                i = max(char[s[j]]+1,i)
            char[s[j]] = j

            length = max((j-i+1),length)
            j += 1

        return length