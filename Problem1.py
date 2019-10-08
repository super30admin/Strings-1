# Time Complexity: O (n + m)(Where n is length of S string and where m is length of T string) 
# Space Complexity: O(M)( where m is length of T string) 
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# - Store character count of T in the dictionary.
# - Iterate through S and if character is in the T, add that character to answer K times (where K is count from dictionary).
# - In the end, Look for any remaining charcater in dictionary and add it to the answer.

class Solution(object):
    def customSortString(self, S, T):
        """
        :type S: str
        :type T: str
        :rtype: str
        """
#       Initialize count
        count = {}
        ans = ""
        
#       Store count of character in the T
        for char in T:
            count[char] = count.get(char, 0) + 1
            
#       Iterate through S
        for char in S:
#           Check that character is also in T
            if char in T:
#               Append answer with count times character and remove that character from dictionary
                ans += char * count[char]
                del count[char]
#       Add remaining character from T into the answer
        for k, v in count.items():
            ans += k * v
            
        return ans
