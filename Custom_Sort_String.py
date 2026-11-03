# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Initialize a HashMap and iterate over string s to add the frequencies of characters in HashMap
# Then iterate over order to check if the character is in HashMap
# If we find a charcter then add it to an result array and multiply by its frequency
# Delete the charcter from HashMap to avoid repeating that character again
# Then iterate over the dict and get the remaning charcters which are not in s multiplied by its frequency
#after that join the result array to get the string



class Solution:
    def customSortString(self, order: str, s: str) -> str:
        result = []
        chdict = {}
        for i in range(len(s)):
            if s[i] not in chdict:
                chdict[s[i]] = 1
            else:
                chdict[s[i]] += 1
        for ch in order:
            if ch in chdict:
                result.append(ch * chdict[ch])
                del chdict[ch]
        
        for ch in chdict:
            result.append(ch * chdict[ch])

        return ''.join(result)
#Time - O(2n + 26) - O(n)
#Space - O(1)