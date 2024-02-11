
"""
807. Custom Sort String
Medium
"""
import collections
from leetcode_runner import LeetCode, TestCase, Args
from typing import *

PROBLEM = """
You are given two strings order and s. All the characters of order are unique and were sorted in some custom order previously.
Permute the characters of s so that they match the order that order was sorted. More specifically, if a character x occurs before a character y in order, then x should occur before y in the permuted string.
Return any permutation of s that satisfies this property.
 
Example 1:

Input: order = "cba", s = "abcd"
Output: "cbad"
Explanation: 
"a", "b", "c" appear in order, so the order of "a", "b", "c" should be "c", "b", and "a". 
Since "d" does not appear in order, it can be at any position in the returned string. "dcba", "cdba", "cbda" are also valid outputs.

Example 2:

Input: order = "cbafg", s = "abcd"
Output: "cbad"

 
Constraints:

1 <= order.length <= 26
1 <= s.length <= 200
order and s consist of lowercase English letters.
All the characters of order are unique.


"""

class Solution:
    """
    Accepted
    Time Complexity: O(m +n) # m is the length of order and n is the length of s
    Space Complexity: O(1) # 26 characters 
    
    Approach:
        The intuiition is to count accumulate all the caracters in order string present in s and then append them in the order of order string.
    """
    def customSortString(self, order: str, s: str) -> str:
        freqs = collections.defaultdict(int)
        for _ in s: # freq of each character in s
            freqs[_] += 1
        res = []
        for _ in order:
            res.append(_  * freqs[_]) # each character in order string times its freq in s
            freqs[_] = 0 # mark it done
        for k,v in freqs.items():
            if v > 0: #remaining characters put them in the end (order doesn't matter)
                res.append(k  * freqs[k])
        return "".join(res)

LeetCode(PROBLEM, Solution).check()
