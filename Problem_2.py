'''
3 Longest Substring Without Repeating Characters
https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

Given a string s, find the length of the longest substring without duplicate characters. A substring is a continguous non-empty sequence of characters within a string.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Constraints:
0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

1. Brute Force:
for each start in range(N):
    for each end in range(N):
        substr = s[start:end+1]
        # check in a map if any char is repeated in substr

Time: O(N^2), Space: O(1)

2. Hash map (sub-optimal)
We traverse each character in the string.
For some current position i in the string,
If the char = string[i] in the hash map:
    Add char to the hash map with value = i + 1
    This is because if we encounter char again (repeated char) in the future during our traversal, then our substring should delete the previous occurrence of char and all characters prior to it.
    Eg. If substring = "abcd" and we encounter 'b' again, then our new substring = "cdb" (we delete "ab" in the substring)

    Instead of deleting from the substring, an easier way is to remove all keys from the hash map that has a value smaller than map[char]. In the above eg, map = {a:1,b:2,c:3,d:4} representing substring = "abcd" and we encounter "b" again. We need to delete 'a' and 'b'. We can do this by collecting all keys whose values are less than or equal to map['b'] = 2. Thus, we delete map['a'], map['b']. Finally, we add 'b' to the map with value = 6 (curr index + 1)
else: char = string[i] not in the hash map:
    Add char to the hash map with value = i + 1

We calculate the max length of substring by using the max (prev len, len(map))
Time: O(N), Space: O(1)

3. Sliding Window + Hash map (optimal)
The approach is similar to the approach in #2 (hash map). The optimality comes in not having to run a for loop to delete the keys in the hash map. Instead, in this approach, we maintain a start pointer, that gets updated to point to the beginning of the substring. If we encounter a repeating character, the start pointer moves to the index of first instance of the repeating character + 1.
But we move the start pointer only if the start pointer does not fall back to a lower value. It should keep increasing.

https://www.youtube.com/watch?v=3XRFYEFTZew
Time: O(N), Space: O(1)
'''
from collections import defaultdict
def lengthOfLongestSubstring_1(s):
    if not s:
        return 0
    N = len(s)
    # create a map that contains characters
    # that are unique in the substring
    map = defaultdict(int)
    max_len = float('-inf')
    for end, c in enumerate(s): # O(N)
        if c not in map:  # curr char c is not repeated
            map[c] = end + 1
        else: # curr char c is repeated
            # delete all keys with values < map[c]
            # and update map[c] with the latest 'end' index
            delete = [k for k in map if map[k] < map[c]] # O(26)
            for k in delete:
                del map[k]
            map[c] = end + 1
        max_len = max(max_len, len(map))
    return max_len

def lengthOfLongestSubstring_2(s):
    if not s:
        return 0
    # create a map that contains characters as keys
    # and the next index to the character as the values
    map = defaultdict(int)
    max_len = float('-inf')
    start = 0
    for end, c in enumerate(s): # O(N)
        if c not in map: # curr char c is not repeated
            map[c] = end + 1
        else: # curr char c is repeated
            # move the new start to the index of first
            # occurrence of repeating char + 1
            # But do this if new start > curr start
            if start < map[c]:
                start = map[c] # new start advances
            map[c] = end + 1
        l = end-start+1
        max_len = max(max_len, l)
    return max_len

def run_lengthOfLongestSubstring():
    tests = [("abcabcbb", 3), ("bbbbb", 1), ("pwwkew", 3), ("aaabcda", 4), ("aaabcdc", 4), ("zabcdfebyzyflm", 7)]
    for test in tests:
        s, ans = test[0], test[1]
        for method in [1, 2]:
            if method == 1:
                l = lengthOfLongestSubstring_1(s)
            elif method == 2:
                l = lengthOfLongestSubstring_2(s)
            print(f"\nstring = {s}")
            print(f"Method {method}: len of longest substring w/o repeating chars = {l}")
            success = (ans == l)
            print(f"Pass: {success}")
            if not success:
                return

run_lengthOfLongestSubstring()
