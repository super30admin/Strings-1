class Solution:
    def customSortString(self, order: str, s: str) -> str:
        # TC O(n) + O(m) => O(n)
        # SC = 1
        if s is None or len(s) == 0:
            return ""
        maps = {}
        for i in range(len(s)):
            if s[i] not in maps:
                maps[s[i]]= 1
            else:
                maps[s[i]]+= 1
        strs = ""
        for i in range(len(order)):
            if order[i] in maps:
                strs += order[i]* maps[order[i]]
                maps.pop(order[i], None)
        
        for k in maps:
            times = maps.get(k)
            strs += k * times
    
        return strs
                
        
        
        
