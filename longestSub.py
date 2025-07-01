"""
Use sliding window with two pointers and a set/map to track characters
Expand right pointer; if duplicate found, move left pointer
Track and update max length at each valid window
"""
"""
Time Complexity: O(n) – each character processed at most twice
Space Complexity: O(min(n, m)) –  m is charset size (e.g., 26 or 128)
"""

class longestSub:
    def lengthOfLongestSubstring(self, s: str) -> int:
        char_index = {} 
        left = max_len = 0

        for right, char in enumerate(s):
            if char in char_index and char_index[char] >= left:
                left = char_index[char] + 1 
            char_index[char] = right
            max_len = max(max_len, right - left + 1)

        return max_len


if __name__ == "__main__":
    obj = longestSub()

    print(obj.lengthOfLongestSubstring("abcabcbb")) 
    print(obj.lengthOfLongestSubstring("bbbbb"))     
    print(obj.lengthOfLongestSubstring("pwwkew"))   
