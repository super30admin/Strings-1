# 791. Custom Sort String
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        Map = {}
        result = ""
        for c in s:
            if c not in Map:
                Map[c] = 0
            Map[c] += 1

        for c in order:
            if c in Map:
                freq = Map[c]
                for _ in range(freq):
                    result += c
                Map.pop(c)

        for key in Map:
            freq = Map[key]
            for _ in range(freq):
                result += key

        return result

        

        