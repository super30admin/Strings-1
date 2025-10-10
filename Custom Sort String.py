'''
Solution: frequency HashMap on string s
    - Build frequency HashMap on string s.
    - iterate over the order, and if current character in order present in freq_map
      add to sort string (with as many frequency)
    - For remaining characters in frequency HashMap, add it to sort string
Time Complexity: O(m+n), m = len(s), n = len(order)
Space Complexity: O(m) 
'''
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        freq_map = {}
        for ch in s:
            freq_map[ch] = freq_map.get(ch,0)
            freq_map[ch]+=1
        
        sort_string = []
        for ch in order:
            if ch in freq_map:
                for k in range(freq_map[ch]):
                    sort_string.append(ch)
                
                freq_map.pop(ch)
        
        
        for remaining_char in freq_map:
            for k in range(freq_map[remaining_char]):
                sort_string.append(remaining_char)
        return "".join(sort_string)