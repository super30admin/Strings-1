# Time Complexity: O(m + n), where m - length of order, n - length of str
# Space Complexity: O(1)

class Solution:
    def customSortString(self, order: str, str: str) -> str:
        if not order or len(order) == 0:
            return str

        result = []

        # Store the count of str characters in hmap
        hmap = dict()
        for ch in str:
            if ch not in hmap:
                hmap[ch] = 0
            hmap[ch] += 1

        # Get the count of order chars from hmap and append it those many times to the result
        for ch in order:
            if ch in hmap:
                count = hmap[ch]
                while count > 0:
                    result.append(ch)
                    count -= 1
                # Remove the appended char from hmap
                hmap.pop(ch)

        # Iterate through the remaining chars from hmap and append to the result
        for ch in hmap:
            count = hmap[ch]
            while count > 0:
                result.append(ch)
                count -= 1

        return "".join(result)

