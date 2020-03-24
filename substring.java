// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach:
//Used hashset for keeping count of charcaters. However, unable to pass all testcases.


class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s == null || s.length() == 0) return 0;
        
        HashSet<Character> set = new HashSet<>();
        
        int count = 0;
        int ans = 0;
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            System.out.println(ch);
            if(!set.contains(ch)){
                set.add(ch);
                count++;
                System.out.println("am new: " + ch);
                ans = Math.max(ans, count);
            }else{
                System.out.println("am there: restart" + ch);
                set.clear();                
                set.add(ch);
                count = 1;
            }
        }
        
        return ans;
    }
}