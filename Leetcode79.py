# Time Complexity - O(n + m)
# Space Complexity - O(n)
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        """
        Sorts s based on the custom order defined in order.
        Time Complexity: O(m + n), where m = len(order) and n = len(s).
        """
        #character frequencies in s
        charCount = Counter(s)

        #result string following order
        result = []
        for ch in order:
            if ch in charCount:
                result.append(ch * charCount[ch])
                del charCount[ch]  # Remove processed characters

        #remaining characters (not in order)
        for ch, count in charCount.items():
            result.append(ch * count)
        return "".join(result)  #list to string
