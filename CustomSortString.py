# Time Complexity : O(S+T)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Initialize a HashMap and iterate over string T to add the frequencies of characters in HashMap
# Then iterate over S to check if the character in S is in HashMap
# If we find a charcter then add it to an empty string res and multiply by its frequency
# Pop the charcter from HashMap to avoid repeating that character again
# Then iterate over the dict and get the remaning charcters which are not in S multiplied by its frequency


class Solution:
    def customSortString(self, S: str, T: str) -> str:
        res = ""
        if not S or not T:
            return res
        dict = {}
        for i in range(len(T)):
            if T[i] not in dict:
                dict[T[i]] = 1
            else:
                dict[T[i]] += 1

        for i in range(len(S)):
            if S[i] in dict:
                res += S[i] * dict[S[i]]
                dict.pop(S[i])

        for key, val in dict.items():
            res += key * dict[key]

        return res