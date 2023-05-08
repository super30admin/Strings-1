# Time Complexity : O(n + m), where n is the length of order and m is the length of str
# Space Complexity : O(m), where m is the length of str
class Solution:
    def customSortString(self, order: str, str: str) -> str:
        char_count = {}
        result = ""
        
        # Count the occurrences of each character in str
        for char in str:
            char_count[char] = char_count.get(char, 0) + 1
        
        # Append the characters in the order defined by order
        for char in order:
            if char in char_count:
                result += char * char_count[char]
                del char_count[char]
        
        # Append the remaining characters not in order
        for char, count in char_count.items():
            result += char * count
        
        return result