//Time Complexity: O(logn)
//Space Complexity: O(n)
//LeetCode: Yes

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0, low = 0, high =0, n = s.length();
        Set<Character> set = new HashSet<>();
        
        while(low<=n && high <= n){
            if(!set.contains(s.charAt(high))){
                set.add(s.charAt(high));
                max = Math.max(max, high - low + 1);
                high++;
                
            } else{
                set.remove(low);
                low++;
            }
        }
        
        return max;
    }
}
