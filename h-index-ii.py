class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        n = len(citations)
        low, high = 0, n
        while low < high:
            mid = (low + high)//2
            if citations[mid] < n - mid:
                low = mid + 1
            else:
                high = mid
        return n - low