class Solution:
    # hash set solution
    # Time Complexity: O(2n)
    # Space Complexity: O(26) -> O(1) -> as hashset will store maximum 26 char to make substring without repetation
    def lengthOfLongestSubstring(self, s: str) -> int:
       
        if s == None or len(s) == 0:
            return 0
        if len(s) == 1:
            return 1
        hashSet = set()
        slow = 0
        fast = 1
        maxx = 0
        hashSet.add(s[0])
        while fast < len(s):
            if s[fast] in hashSet:
                while s[slow] != s[fast]:
                    hashSet.remove(s[slow])
                    slow = slow + 1
                    
                slow = slow + 1
            maxx = max(maxx, fast - slow + 1)
            hashSet.add(s[fast])
            fast +=1
            
        return maxx




    # hash map solution
    # Time Complexity: O(n)
    # Space Complexity: O(26) -> O(1) -> as hashmap will store maximum 26 char to make substring without repetation
    def lengthOfLongestSubstring2(self, s: str) -> int:
        
        hashmap = {}
        slow = 0
        maxx = 0
        for i in range(0,len(s)):
            char = s[i]
            if char in hashmap:
                slow = max(slow,hashmap[char])  
                
            maxx = max(maxx, i - slow + 1)
            hashmap[char] = i+1
        return maxx

      
    