"""
Problem : 2

Time Complexity : 
Deque - O(n)
Hashset - O(1)

Space Complexity : 
Deque - O(n)
hashset - O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Deque - creating a queue, adding characters from the right side, until a character which is already present 
inside deque is encountered, then calculating the current size of the deque, and comparing with the max size,
popping from the left from the deque until the current character's previous occurence is found,
popping it too, and appending the new occurence, and continue this until the end of the string

Hashset - Iterating over the string and appending the character to the hashset until a character which
is already inside the hashset is encountered, then removing the elements in the order they got appended until
the current element is found, moving the pointer to that location, and updating the maximum length of substring
based on the current index and index of recently deleted same character. Repeating until end of the string

"""

# Longest substring without repeating characters

# Approach - 1
# Double ended queue

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        dq=collections.deque()
        maxx=0
        start=0

        for i in range(len(s)):
            if s[i] in dq:
                maxx=max(maxx,len(dq))
                while True:
                    popped=dq.popleft()
                    if popped==s[i]:
                        dq.append(s[i])

                        break
                # start=i+1
            else:
                dq.append(s[i])
        maxx=max(maxx,len(dq))
        return maxx



# Approach - 2
# Hashset

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hset=set()
        slow=0
        maxx=0
        for i in range(len(s)):
            c=s[i]
            if c in hset:
                while s[slow]!=c:
                    hset.remove(s[slow])
                    slow+=1
                slow+=1
            else:
                hset.add(c)
            maxx=max(maxx,i-slow+1)
        return maxx
