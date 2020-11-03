"""
Name: Srindihi
Did it run on LC: yes
Time Complexity: O(len(S)+len(T)) - Goint throught both the strings
Space Complexity: O(len(T)) - Storing T freq map in a hashmap 

Logic:
Since T is the string which can have extra chars, maintain a freq hashmap of T
for every char in S, if that char is in the map, use the char to contruct the new version of T

In the end, add the remaining characters which are not in the map. 

new_T = S + (characters not in S)
"""
class Solution:
    def customSortString(self, S: str, T: str) -> str:
        freq_map = {}
        
        for char in T:
            freq_map[char] = freq_map.get(char,0)+1
        
        ans = []
        for c in S:
            if c in freq_map:
                ans.append(c*freq_map[c])
                freq_map[c] = 0
        
        for c in freq_map:
            ans.append(c*freq_map[c])
        return ''.join(ans)