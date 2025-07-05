# Time complexity: O(n)
# Space complexity: O(min(n, m))

def lengthOfLongestSubstring(s):
    seen_so_far = {}
    max_length_string = 0
    start = 0

    for end, char in enumerate(s):
        if char in seen_so_far and seen_so_far[char] >= start:
            start = seen_so_far[char] + 1
        seen_so_far[char] = end
        max_length_string = max(max_length_string, end - start + 1)

    return max_length_string
