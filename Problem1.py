#I implemented the customSortString function which takes two strings: order and s. The approach involves first creating a frequency dictionary to count the occurrences of each character in s. Then, I construct the resulting string by iterating through the characters in order, appending characters to the result string based on their frequency in the original string and removing them from the frequency dictionary. Finally, any remaining characters (those not present in order) are appended to the result string in their original order of appearance. The time complexity of this solution is O(n+m), where n is the length of s and m is the length of order, because we iterate through both strings once and perform dictionary operations. The space complexity is O(n) due to the storage required for the frequency dictionary, which holds a count for each unique character in s.

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        freq = {char: 0 for char in s}
        for char in s:
            freq[char] += 1
        result = ""
        for char in order:
            if char in freq:
                result += char * freq[char]
                del freq[char]
        for char, count in freq.items():
            result += char * count
        return result