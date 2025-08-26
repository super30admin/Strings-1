class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        map_letter = {}
        i = 0
        j = 0
        max_length = 0

        while j < len(s):
            if s[j] not in map_letter:
                map_letter[s[j]] = j
                print(map_letter)
            else:
                if s[j] in map_letter and i <= map_letter[s[j]]:
                    i = map_letter[s[j]] + 1
                    map_letter[s[j]] = j
                else:
                    map_letter[s[j]] = j
            max_length = max(max_length, j - i + 1)
            j = j + 1
        return max_length