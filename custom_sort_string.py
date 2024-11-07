class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hash_map = {}

        for char in s:
            if char in hash_map.keys():
                hash_map[char] += 1
            else:
                hash_map[char] = 1
        result = []

        for char in order:
            if char in hash_map:
                result.append(char * hash_map[char])
                del hash_map[char]
        for char, freq in hash_map.items():
            result.append(char * freq)

        return "".join(result)


# time complexity is O(n+m) where n is the length of s and m is length of order
# space complexity is O(n+m) where n is the length of s and m is length of order
