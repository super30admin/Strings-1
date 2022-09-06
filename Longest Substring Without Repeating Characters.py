# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        i = 0 # Start ptr of the substring
        j = 0 # End ptr of the sbstring
        d = {}
        ans = 0
        while j < len(s):
            if s[j] not in d or i>d[s[j]]:
                # If index current end character at index j is not in the hashmap or if it is there but the value of it in the hashmap is less than i, our start element, we update the value if s[j] in the hashmap to j 
                ans = max(ans,(j-i+1)) # Check the max among max and current substring and store it in max
                d[s[j]] = j
            else:
                # If s[j] is in hashmap and at an index after i (the start of the window), it means that there is a repetition
                # No shift the start ptr to the index after the previous occurence of the repeated character which is the index after the value in the hashmap
                i = d[s[j]]+1
                ans = max(ans,(j-i+1))
                j -= 1 # Adding this because we have increment of j in the next step and since we have changed the position of i, we need to check for the substring from the updated i to j again before moving j to j+1
            j+=1
        return ans