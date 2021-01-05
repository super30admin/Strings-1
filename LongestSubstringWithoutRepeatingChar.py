
"""
Approach: Two pointers

Here we will be maintaining two pointers, slow and fast which will point to first character initially. Fast will iterate over every character one by one and slow will only move if the repeating character is found.

Now here we will also maintain a hashmap in which we will store the indices of the unique characters that we have encountered up till now. 

So now whenever fast pointer moves ahead we will check for the character in the hashmap, if it is already present we will move out slow pointer to the max of the index we got out of the hashmap and current slow pointer.

Also the max length would also be maintained using fast - slow + 1
Time complexity: O(n)
Space complexity: O(n)

where n = length of the string

Here we are using hashmap to store the characters. 
"""
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if s == None and len(s) == 0:
            return 0
        hmap = {}
        
        slow = 0
        maxi = 0
        
        result = [] # If the orginal substring is also asked
        for fast in range(len(s)):
            c = s[fast]
            
            if c in hmap:
                slow = max(slow, hmap[c])
                
            hmap[c] = fast + 1
            
            # curr = fast - slow + 1
            # if curr > maxi:
            #     result = []
            #     result.append(s[slow:fast + 1])
            # elif curr == maxi:
            #     result.append(s[slow:fast + 1])
            
            maxi = max(maxi, fast - slow + 1)
        
        print(result)
        return maxi
        