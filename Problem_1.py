'''
791 Custom Sort String
https://leetcode.com/problems/custom-sort-string/description/

You are given two strings order and s. All the characters of order are unique and were sorted in some custom order previously.

Permute the characters of s so that they match the order that order was sorted. More specifically, if a character x occurs before a character y in order, then x should occur before y in the permuted string.

Return any permutation of s that satisfies this property.

Example 1:
Input: order = "cba", s = "abcd"
Output: "cbad"
Explanation: "a", "b", "c" appear in order, so the order of "a", "b", "c" should be "c", "b", and "a". Since "d" does not appear in order, it can be at any position in the returned string. "dcba", "cdba", "cbda" are also valid outputs.

Example 2:
Input: order = "bcafg", s = "abcd"
Output: "bcad"
Explanation: The characters "b", "c", and "a" from order dictate the order for the characters in s. The character "d" in s does not appear in order, so its position is flexible.

Following the order of appearance in order, "b", "c", and "a" from s should be arranged as "b", "c", "a". "d" can be placed at any position since it's not in order. The output "bcad" correctly follows this rule. Other arrangements like "dbca" or "bcda" would also be valid, as long as "b", "c", "a" maintain their order.

Constraints:
1 <= order.length <= 26
1 <= s.length <= 200
order and s consist of lowercase English letters.
All the characters of order are unique.

M = len(order), N = len(s)

Solution:
1. Brute Force
For each char in order, traverse the string s. If c matches a char in s, store the result.
Time: O(MN), Space: O(1)

2. Hash Map
Save the freq count of each char is s in a hash map 'h'. Now for each char c in order, do a lookup of c in the hash map. If it exists, print c along with its freq count (c*h[c]), append the string to a result string, and delete c from the hash map.
Finally, if there are any characters left in s that were not in order, we append them to the end of the result string. Since the order of these leftover characters doesn't matter, we simply append them in any order they occur.

https://youtu.be/HYUIYzr1Hv0?t=3752
Time: O(M+N), Space: O(1)
'''
from collections import defaultdict

def customSortString(order, s):
    ''' Time: O(M+N), Space: O(1) (hash map max size O(26) = constant) '''
    if not order or not s:
      return s
    h = defaultdict(int)
    for c in s:
       h[c] += 1 # keys of h preserve all the unique chars appearing in s

    result = ""
    # for characters that appear in both order and s
    for c in order:
       if c in h:
          result += c*h[c]
          del h[c]
    # for characters that do not appear in order but appear in s
    for c in h:
        result += c*h[c]
    return result


def run_customSortString():
    tests = [('cba', "acbcad", "ccbaad"), ("cba", "abcd", "cbad"), ("bcafg", "abcd", "bcad")]
    for test in tests:
        order, s, ans = test[0], test[1], test[2]
        result = customSortString(order, s)
        print(f"\nOrder = {order}")
        print(f"s = {s}")
        print(f"Result = {result}")
        success = (ans == result)
        print(f"Pass: {success}")
        if not success:
            return

run_customSortString()
