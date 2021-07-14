class Solution:
    def customSortString(self, order: str, str: str) -> str:
        result = ''
        if str == None or len(str) == 0:
            return result
        map = {}
        
        for i in range(len(str)):
            if str[i] in map.keys():
                map[str[i]] += 1
            else:
                map[str[i]] = 1
            
        for i in range(len(order)):
            if order[i] in map.keys():
                cnt = map[order[i]]
                while cnt > 0:
                    result += order[i]
                    cnt -= 1
                map.pop(order[i], None)
        
        for key in map:
            cnt = map[key]
            while cnt > 0:
                result += key
                cnt -= 1
        return result

# Time Complexity: O(n + m)
# Space Complexity: O(1)