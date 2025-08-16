# Time Complexity: O(n+m)
# Space Complexity: O(1)
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        s_map = {}

        for ch in s:
            s_map[ch] = s_map.get(ch, 0) + 1

        result = []

        for ch in order:
            if ch in s_map:
                cnt = s_map[ch]
                for j in range(cnt):
                    result.append(ch)
                del s_map[ch]

        for k in s_map:
            count = s_map[k]
            for l in range(count):
                result.append(k)

        return ''.join(result)
