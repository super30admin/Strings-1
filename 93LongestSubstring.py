"""
    // Time Complexity :T = O(n)
    // Space Complexity :O(26)
    // Did this code successfully run on Leetcode : YES
    // Any problem you faced while coding this : NA
    // Explanation:
    iterate over the string,if character is already present in
    hashMap,update slow pointer

    if character not present in hashmap, store the character<-> index+1 in
    hashMap;fast += 1

    Note: in hashmap, index+1 is stored because while updating slow,
    the hashmap should return exact index location

"""
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # edge case
        if s is None or len(s) == 0 :
            return 0

        # logic
        mx = 0
        hashMap = {}
        slow = 0
        fast = 0
        for i in range(len(s)):
          #print("f=",fast+1,"s=",slow+1,mx,s[i],hashMap)
          if s[i] in hashMap:
            slow = max(slow,hashMap.get(s[i]))
          mx = max(mx,fast - slow +1)
          hashMap[s[i]] = i+1
          fast += 1
        return mx
