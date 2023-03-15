"""
Rasika Sasturkar
Time Complexity: O(n)
Space Complexity: O(256) = O(1)
"""


def lengthOfLongestSubstring(s: str) -> int:
    """
    This problem can be solved using 2 optimal approaches - hashsets & hashmaps.
    In both approaches, we use fast and slow pointers. In hashsets, we store the
    characters in hashsets to avoid repeating characters in string, and in hashmap
    we store index of the characters along with the characters to avoid the extra
    loop in the hashset implementation.
    """
    # null case
    if len(s) == 0:
        return 0
    if len(s) == 1:
        return 1

    max_len = 0

    # Using Hashmap
    char_map = {}
    slow = 0

    for fast in range(len(s)):
        char = s[fast]
        if char in char_map:
            slow = max(slow, char_map[char] + 1)
        max_len = max(max_len, fast - slow + 1)
        char_map[char] = fast

    # Using Hashsets
    # char_set = set()
    # char_set.add(s[0])
    # slow, fast = 0, 1
    #
    # while fast < len(s):
    #     char = s[fast]
    #     if char in char_set:
    #         while s[slow] != char:
    #             char_set.remove(s[slow])
    #             slow += 1
    #         slow += 1
    #     max_len = max(max_len, fast - slow + 1)
    #     char_set.add(char)
    #     fast += 1

    return max_len


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    print(lengthOfLongestSubstring(s="abcabcbb"))  # returns 3
    print(lengthOfLongestSubstring(s="bbbbb"))  # returns 1
    print(lengthOfLongestSubstring(s="pwwkew"))  # returns 3


if __name__ == "__main__":
    main()
