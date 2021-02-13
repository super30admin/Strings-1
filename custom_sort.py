# Time Complexity : O(n) where n is length of T
# Space Complexity : O(m) weher m is length of S
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I iterate through T and maintain a count of letters in a map. Then I go through S and add a letter x times if its present in map where
# x is the number of times it was present in T. I then add all the remaining letters in their original order
# https://leetcode.com/problems/custom-sort-string/

class Solution:
    def customSortString(self, S: str, T: str) -> str:
        mapping = defaultdict(lambda : 0)
        result = []
        og_s = set()
        
        for letter in T:
            mapping[letter] += 1
            
        for letter in S:
            times = mapping[letter]
            result += times*letter
            og_s.add(letter)
            
        for letter in T:
            if letter not in og_s:
                result += letter
            
        return "".join(result)
