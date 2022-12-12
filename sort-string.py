# TC:O(N
# SC:O(s) 
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        s_counts=collections.Counter(s)

        string_builder=[]

        for char in order:
            if char in s_counts:
                string_builder.extend([char]*s_counts[char])

                del s_counts[char]
        
        for char,count in s_counts.items():
            string_builder.extend([char]*count)

        return "".join(string_builder)