# Time Complexity: O(n) where n is the length of the string s
# Space Complexity: O(1) since the hashmap will have atmost 26 characters
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
The problem is solved by using hashmap to store the frequency of each character in the string s. Then we 
itereate through the order string and put in characters from the hashmap into the answer and then finally 
append the remaining characters to the answer.
"""

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        if order == None or len(order) == 0 or s == None or len(s) == 0:
            return []

        hashmap = Counter(s)
        answer = []
        
        for char in order:
            for _ in range(hashmap[char]):
                answer.append(char)
            hashmap[char] = 0

        for key, value in hashmap.items():
            for _ in range(value):
                answer.append(key)

        return ''.join(answer)
