"""
TC: O(m + n)
SC: O(1)

Approach:
    - Record the count of all the occurences in s in a hash map
    - Loop over the order and check if it's in the occurences
        - if yes add to the output
        - Delete the key after adding the character n times to the output 
    
    - Loop over the remaining characters which are not in order and add it to the res
    - Return the result
"""
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        occurences = dict()
        for i in range(len(s)):
            if s[i] in occurences:
                occurences[s[i]] += 1
            else:
                occurences[s[i]] = 1
        res = ""
        for i in range(len(order)):
            if order[i] in occurences:
                res += order[i] * occurences[order[i]]
                del occurences[order[i]]

        for i in occurences:
            res += i*occurences[i]
        return res