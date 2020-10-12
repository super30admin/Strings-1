# Leetcode problem link : https://leetcode.com/problems/custom-sort-string/
# Time Complexity:    O(m+n) where m is the length of S and n is the length of T
# Space Complexity:   O(n) for hashmap
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
        Store the characters in T wth their frequencies in hashmap.
        Iterate through each character in S i.e. custom sorted string and check if map contains the character ( t contains that character). If it exists then add all the occurrences in output string at once (sorting means priority is same for all occurrences of one character)
        Once all characters in custom sorted string are appended, left over characters in map can be appended in any sequence
'''     
class Solution:
    def customSortString(self, S: str, T: str) -> str:
        t_map = {}
        
        for c in T:
            if c in t_map:
                t_map[c] += 1
            else:
                t_map[c] = 1
        
        output = ''
        for ch in S:
            if ch in t_map:
                count = t_map[ch]
                while count > 0:
                    output += ch
                    count -= 1
                del t_map[ch]
        
        for leftover in t_map:
            count = t_map[leftover]
            while count > 0:
                output += leftover
                count -= 1
            # del t_map[leftover]
        return output