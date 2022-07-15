/* Time Complexity: O(2n) -> O(n)
 * Space Complexity: O(1)
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : No
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        //null
        if(s == null || s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        HashSet<Character> set = new HashSet<>();
        int slow = 0;
        int fast = 1;
        int max = 0;
        set.add(s.charAt(0));
        while(fast < s.length()){
            char c = s.charAt(fast);
            if(set.contains(c)){
                //move your slow pointer till that char is not escaped from slow side
                while(s.charAt(slow) != c){
                    set.remove(s.charAt(slow));
                    slow++;
                }
                slow++;
            }
            max = Math.max(max, fast - slow + 1);
            set.add(c);
            fast++;
        }
        return max;
    }
}
