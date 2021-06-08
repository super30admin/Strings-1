"""3. Longest Substring Without Repeating Characters
Time Complexity: O(n)
Space Complexity: O(m) m-> size of hashmap """
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if s is None or len(s)==0:
            return 0
        slow = 0
        fast = 0
        maxcount =0
        hashmap = {} # store location of characters in map
        
        while fast<len(s):
            c=s[fast]
            if c in hashmap:
                slow = max(slow,hashmap[c])
            hashmap[c] =fast+1
            maxcount = max(maxcount,fast-slow+1)
            
            fast+=1
        return maxcount
            