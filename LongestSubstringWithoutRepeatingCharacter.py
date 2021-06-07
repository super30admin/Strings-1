# TC: O(N) since we are traversing all the elements in the string. 
# SC: O(N) in worst case, we will end up inserting all the characters of the input string into the hashmap. 

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s or len(s) == 0: 
            return 0
        
        slow = fast = max_len = 0
        hmap = {}
        while fast < len(s): 
            curr = s[fast]
            if curr in hmap.keys(): 
                slow = max(slow, hmap.get(curr))
            hmap[curr] = fast + 1
            max_len = max(max_len, (fast - slow) + 1)
            fast += 1
        
        return max_len
