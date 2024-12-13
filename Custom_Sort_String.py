# Approach:
# We are given a string `order` that defines a custom order of characters.
# We are also given a string `s`, and we need to sort the characters of `s` to match the order defined in `order`.
# We will first create a dictionary to store the index of each character in `order`, so that we can quickly compare their relative order.
# We will then sort the characters of `s` based on their order in `order`. Characters not in `order` will be placed at the end, maintaining their relative order.

# Time Complexity: O(n log n), where n is the length of the string `s`. Sorting the string `s` takes O(n log n) time.
# Space Complexity: O(m), where m is the length of the `order` string. We use a dictionary to store the index of each character in `order`.
# Did this code successfully run on Leetcode: Yes, the code runs successfully and passes all test cases.
# Any problem you faced while coding this: No issues, but making sure to correctly handle characters that are not in the `order` string was important.


class Solution:
    def customSortString(self, order: str, s: str) -> str:
        # Create a dictionary that stores the position of each character in 'order'
        order_map = {char: i for i, char in enumerate(order)}
        
        # Sort the string `s` based on the order in `order_map`
        # If a character is not in `order_map`, assign it a large value (e.g., len(order)) to place it at the end
        sorted_s = sorted(s, key=lambda x: order_map.get(x, len(order)))
        
        # Join the sorted characters into a string and return
        return ''.join(sorted_s)
