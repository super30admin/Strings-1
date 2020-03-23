# Problem 1 - Custom sort string
## Time Complexity :
O()

## Space Complexity :
O()

## Did this code successfully run on Leetcode :


## Any problem you faced while coding this :


## Your code here along with comments explaining your approach
### Solution:


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
