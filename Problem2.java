//Time complexity : O(n)
//Space Complexity : O(n)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s==null || s.length()<0){
            return -1;
        }
        
        int start=0;
        int end=0;
        int max=0;
        
        
        HashSet<Character> set = new HashSet<>();
        
        while(start<s.length() && end<s.length()){
            
            if(set.contains(s.charAt(end))){
                start++;
                set = new HashSet<>();
                end=start;
            }else{
                set.add(s.charAt(end));
                int len=end-start+1;
            
                if(len > max){
                    max=len;
                 }
                end++;
             }
            
        }
        return max;
    }    
}