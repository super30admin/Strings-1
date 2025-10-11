# Time Complexity : O(N) where N is the length of the input string
# Space Complexity : O(1) as we are using a fixed size hashmap of 26 characters
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach:
# I am using a hashmap to store the frequency of each character in the string s by using the Counter class from the collections module.
# The counter class creates a dictionary where the keys are the characters and the values are their frequencies.
# I am iterating through the order string and for each character, I am checking if it is present in the hashmap.
# If it is, I am appending the character to the result list as many times as its frequency in the hashmap.
# After processing all characters in the order string, I am appending the remaining characters in the hashmap to the result list.
# Finally, I am joining the result list to form a string and returning it.


from collections import Counter
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hashmap = Counter(s)
        result = []
        for i in order:
            if i in hashmap:
                while hashmap[i]:
                    result.append(i)
                    hashmap[i] -= 1
                del hashmap[i]
        for i in hashmap:
            while hashmap[i]:
                result.append(i)
                hashmap[i] -= 1
        return "".join(result)
