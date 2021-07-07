# Problem 1 - Custom sort string
## Time Complexity :
O(n)

## Space Complexity :
O(n)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
Yes. It was difficult to interpret the problem in the beginning. I do not know if this is the optimized solution, and couldn't find a better solution. 

## Your code here along with comments explaining your approach
### Solution:
      from collections import Counter

      class Solution:
          def customSortString(self, S: str, T: str) -> str:
              counter = Counter(T)
              output = []

              for s in S:
                  if s in counter:
                      output.extend(s * counter[s])
                      del counter[s]

              for c, freq in counter.items():
                  output.extend(c * freq)

              return ''.join(output)


# Problem 2 - Longest Substring Without Repeating Characters
## Time Complexity :
O(n)

## Space Complexity :
O(n)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No.

## Your code here along with comments explaining your approach
### Solution:
      class Solution:
          def lengthOfLongestSubstring(self, s: str) -> int:
              max_len = 0
              sub = ''

              for l in s:
                  if l in sub:
                      sub = sub[sub.find(l)+1:]        
                  sub += l
                  if len(sub) > max_len:
                      max_len = len(sub)

              return max_len
