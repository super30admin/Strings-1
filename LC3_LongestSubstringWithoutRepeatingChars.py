"""
Brute Force -
Make all combination of substrings and check for repeted elements
TC - O(n*n)

M2 
Two Pointer
We will keep a slow and a fast pointer and when we come across a character which is already there in the string, we move the slow pointer right next to the repeating char in the word

TC = O(2n)
SC - O(26) = O(1)

"""

"""
M3
Hashmap
We can store the index of all the characters in the hashmap as and when we come across the new alphabet

once we come across a repeating char, we move the slow pointer,shift it to max(pos after the repeating char's first occurence,current slow pointer)
and update its position in the hashmap
TC = O(n) - n = length of the string
SC = O(1)
"""

class Solution:
    def lengthOfLongestSubstring(self, word: str) -> int:
        if word is None or len(word)==1:
            return 1
        if word is " ":
            return 1
        hmap={}
        result = 0
        #maxl = len(s)
        s = 0
        
        for i in range(len(word)):
            if word[i] in hmap:
                s=max(s,hmap[word[i]])
            temp = i-s+1
            result = max(result, temp)
            hmap[word[i]]= i+1
            
        return result
    
