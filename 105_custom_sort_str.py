# Time complexity - O(s) + O(26) (max order can be of length 26)
# Space complexity - O(26) -> O(1) # for frequency map

# Approach - Create a frequency map. Iterate through the order, find the char in map,
# append it to result as many times it occurs in s, delete that char from map. Finally
# iterate over the remaining chars in map and append it to result. Return str(result)

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        freq_map = dict()
        result = []
        for i in s:
            if i not in freq_map:
                freq_map[i] = 1
            else:
                freq_map[i] += 1
        
        for i in order:
            if i in freq_map:
                times = freq_map[i]
                for j in range(times):
                    result.append(i)
                del freq_map[i]
        
        for k, v in freq_map.items():
            for j in range(v):
                result.append(k)
        
        return "".join(result)