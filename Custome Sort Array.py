// Time Complexity : O(n) to store each character in map and then again building it
 // Space Complexity : O(1) since the number of characters is constant in the map
 // Did this code successfully run on Leetcode : Yes
 // Any problem you faced while coding this : No  


class Solution:
    def customSortString(self, order: str, s: str) -> str:
        maps = {}
        for i in range(len(s)):
            maps[s[i]] =1 + maps.get(s[i],0)
        string = ''
        for i in range (len(order)):
            if order[i] in maps.keys():
                # for i in range(maps[order[i]]):
                string +=order[i]*maps[order[i]]
                maps[order[i]]=0
        for key in maps.keys():
            if maps[key]!=0:
                # for i in range(maps[key]):
                string +=key*maps[key]
        return string
       
                    
                    
        
        
        
        
        
      