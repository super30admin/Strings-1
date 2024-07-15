# Time Complexity : O(m+n), where m is the size of the order string and n is the size of string s
# Space Complexity : O(n)

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        if not order or not s:
            return s

        count = [0] * 26
        result = []

        # Count each character in s
        for c in s:
            count[ord(c) - ord('a')] += 1

        # Append characters in the order specified in 'order'
        for c in order:
            while count[ord(c) - ord('a')] > 0:
                result.append(c)
                count[ord(c) - ord('a')] -= 1

        # Append remaining characters that were not in 'order' in their original order
        for c in s:
            if count[ord(c) - ord('a')] > 0:
                result.append(c)
                count[ord(c) - ord('a')] -= 1

        return ''.join(result)

# Examples
sol = Solution()

# Example 1
order1 = "cba"
s1 = "abcd"
print(sol.customSortString(order1, s1))  # Output: "cbad"

# Example 2
order2 = "kqep"
s2 = "pekeqpp"
print(sol.customSortString(order2, s2))  # Output: "kqeeppp"

# Example 3
order3 = "xyz"
s3 = "yxzzyx"
print(sol.customSortString(order3, s3))  # Output: "xxyyzz"