# Time Complexity : O(n)
# Space Complexity : O(n)

# Approach:
# 1. Create a hash map to store the last seen index of each character.
# 2. Initialize two pointers, l and r, to represent the left and right ends of the sliding window.
# 3. Iterate through the string with the right pointer r.
# 4. If the character at the right pointer is already in the hash map and its last seen index is greater than or equal to l,
#    update l to the last seen index + 1.
# 5. Update the last seen index of the character at the right pointer to r.
# 6. Move the right pointer to the next character.
# 7. Calculate the length of the current substring without repeating characters as r - l.
# 8. Update the maximum length found so far.
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # sliding window + hash map logic
        # Initialize a window variable to keep track of the length of the longest substring without repeating characters
        window = 0
        # Initialize two pointers, l and r, to represent the left and right ends of the sliding window
        l, r = 0, 0
        # Create a hash map to store the last seen index of each character
        seen = {}

        # Iterate through the string with the right pointer r
        while r < len(s):
            # If the character at the right pointer is already in the hash map and its last seen index is greater than or equal to l,
            # update l to the last seen index + 1
            if s[r] in seen:
                # Update the length of the current substring without repeating characters
                window = max(window, r-l)
                # Update l to the last seen index + 1
                if seen[s[r]]+1 > l:
                    l = seen[s[r]] + 1
            # Update the last seen index of the character at the right pointer to r
            seen[s[r]] = r
            # Move the right pointer to the next character
            r += 1
        # We calculate the maximum window one last time after the loop ends because the last character may not have been counted
        window = max(window, r-l)
        # Return the maximum length found so far
        return window

# Time Complexity : O(2n)
# Space Complexity : O(1)

# Approach:
# 1. Create a set to store the characters in the current substring.
# 2. Initialize two pointers, l and r, to represent the left and right ends of the sliding window.
# 3. Iterate through the string with the right pointer r.
# 4. If the character at the right pointer is already in the set, update the length of the current substring without repeating characters.
# 5. Move the left pointer l to the right until the character at the right pointer is no longer in the set.
# 6. Add the character at the right pointer to the set.
# 7. Move the right pointer to the next character.
# 8. Calculate the length of the current substring without repeating characters as r - l.
# 9. Update the maximum length found so far.   
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # sliding window logic
        # Initialize a window variable to keep track of the length of the longest substring without repeating characters
        window = 0
        # Initialize two pointers, l and r, to represent the left and right ends of the sliding window
        l, r = 0, 0
        # Create a set to store the characters in the current substring
        seen = set()
        # Iterate through the string with the right pointer r
        while r < len(s):
            # If the character at the right pointer is already in the set, update the length of the current substring without repeating characters
            if s[r] in seen:
                window = max(window, r-l)
                # Move the left pointer l to the right until the character at the right pointer is no longer in the set
                while s[r] in seen:
                    seen.remove(s[l])
                    l += 1
            # Add the character at the right pointer to the set
            seen.add(s[r])
            # Move the right pointer to the next character
            r += 1
        # We calculate the maximum window one last time after the loop ends because the last character may not have been counted
        window = max(window, r-l)
        # Return the maximum length found so far
        return window