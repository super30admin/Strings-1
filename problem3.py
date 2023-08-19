# https://leetcode.com/problems/longest-word-in-dictionary/
# Time Complexity: O(nlogn)
# Space Complexity: O(n)

class Solution:
    def longestWord(self, words: List[str]) -> str:
        words.sort()  # Sort the words lexicographically
        word_set = set([""])
        longest_word = ""
        
        for word in words:
            if word[:-1] in word_set:
                word_set.add(word)
                if len(word) > len(longest_word):
                    longest_word = word
        
        return longest_word
