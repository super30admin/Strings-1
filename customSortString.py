class Solution:
    def customSortString(self, order: str, s: str) -> str:
        # T: O(n), S: O(n)
        # Count occurrences of characters in s
        freq = Counter(s)

        # Build the sorted result
        result = []

        # Add characters in the order defined by 'order'
        for char in order:
            if char in freq:
                result.append(char * freq[char])  # Append char freq[char] times
                del freq[char]  # Remove processed character

        # Append remaining characters (not in 'order') in any order
        for char, count in freq.items():
            result.append(char * count)

        return "".join(result)
