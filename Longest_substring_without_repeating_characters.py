# Time - O(N)
# space- O(N)
# Using hashset and storing count 



class Solution:
    def myPow(self, x: float, n: int) -> float:
        
        if n == 0: 
            return 1
        if n < 0:
            return 1/self.myPow(x, -n)
        
        lower = self.myPow(x, n//2)
        if n % 2 == 0:
            return lower*lower
        else: 
            return lower*lower*x
    
