class Solution:
    def customSortString(self, order: str, s: str) -> str:
        my_dict = {}
        result = ""
        for char in s:
            if char in my_dict:
                my_dict[char] += 1
            else:
                my_dict[char] = 1
        for c in order:
            if c in my_dict:
                result += c * my_dict[c]
                my_dict.pop(c)
        for key, value in my_dict.items():
            result += key * value
        return result