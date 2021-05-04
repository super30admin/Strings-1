//Time Complexity : O(n)
//Space Complexity: O(1). the hashmap is not considered as the number of English letters, digits, symbols and spaces are constant
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
// Your code here along with comments explaining your approach
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0 || s == ""){
            return 0;
        }
        HashMap<Character,Integer> map = new HashMap<>();//use hashmap to avoid repeatitiveness
        int max = -1,slow=0;//use two pointers
        for(int fast=0;fast<s.length();fast++){
            if(map.containsKey(s.charAt(fast))){
                slow = Math.max(map.get(s.charAt(fast)),slow);//to avoid slow pointer from going back and move forward
            }
            max = Math.max(max,fast-slow+1);
            map.put(s.charAt(fast),fast+1);
        }
        return max;
    }
}