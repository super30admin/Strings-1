"""
    // Time Complexity :T = O(n)
    // Space Complexity :O(1)
    // Did this code successfully run on Leetcode : YES
    // Any problem you faced while coding this : NA
    // Explanation:
    iterate over string T, add the character<->number of occurence in hashmap
    iterate over string S,check if the character is in hashmap,
    if is, multiply the character by the it's occurence from hashmap
    iterate over T, append the characters that are not in S at the end of the result
"""
class Solution:
    def customSortString(self, S: str, T: str) -> str:
        memory = {}
        result = []

        for i in range(len(T)):
            if T[i] in memory:
                memory[T[i]] = memory.get(T[i])+1
            else:
                memory[T[i]] = 1

        for j in range(len(S)):
            if S[j] in memory:
                result.append(S[j] * memory.get(S[j]))


        for key in memory:
            if key not in S:
                result.append(memory.get(key)*key)
        return "".join(result)
