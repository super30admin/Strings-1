"""
FAANMG Problem #95 {Medium} 

3. Longest Substring Without Repeating Characters


Time Complexity O(n)
Space Complexity:  O(1) - 26 Char
        
Did this code successfully run on Leetcode : Yes

Sliding window Sol

Approach --
1. Place the pointer slow and fast(which will be the idx) = 0
2. Create a hashMap of characters in a sting, move fast pointer and add respective character in hashMap with key as character and value as index + 1.
3. Everytime we move the fast pointer check if the character is present in hashMap.
4. If it is present, get its corresponding value from hashMap and move the slow pointer to the max(hashMap value , slow pointer's value). Maximum value because the character we are checking should be between range of current sliding window.
5. Calculate the maximum length as fast-slow + 1

@name: Rahul Govindkumar_RN27JUL2022
"""
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        hashmap = collections.defaultdict(int)
    
        slow = 0
        maxVal=0
        
        for idx,val in enumerate(s):
            
            if val in hashmap:
                slow = max(slow,hashmap[val])
                
            hashmap[val] = idx+1
            maxVal= max(maxVal, idx-slow+1)
            
        return maxVal
    

"""
Sliding window Sol Using Set

Approach --
1. Place the pointer slow and fast(which will be the idx) = 0
2. Create a hashset of characters in a sting, move fast pointer and add respective character in hashSet  
3. Everytime we move the fast pointer check if the character is present in hashSet.
4. If it is present, remove the character that Slow is pointing  and move the slow pointer +1 till there is no element as s[fast] in set
5. Calculate the maximum length as fast-slow + 1 and add the curr characket to the hashser

@name: Rahul Govindkumar_RN27JUL2022
"""
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        hashset = set()
        
        slow = 0
        maxV = 0
        
        for r in range(len(s)):
            ch = s[r]
           
            while ch in hashset:
                
                hashset.remove(s[slow])
                slow +=1
               
            hashset.add(s[r])
            
            maxV = max(maxV, r -slow +1)
            
        return maxV


