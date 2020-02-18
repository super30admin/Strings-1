// S30 Big N Problem #92 {Medium}
// 3. Longest Substring Without Repeating Characters
// Time Complexity :O(n*n)
// Space Complexity :O(n) where n is the length of string
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None


// Your code here along with comments explaining your approach
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0) return 0;
        
        HashSet<Character> set=new HashSet<>();
        //char [] carray=s.toCharArray();
        int result=0;
        int j=0;
        for(int i=0;i<s.length();i++){//O(n)
            char c=s.charAt(i);
            if(!set.contains(c)){
                set.add(c);
                result=Math.max(set.size(),result);
            }else{
                while(j<i){//O(n)
                    if(s.charAt(j)==c){
                        j++;
                        break;
                    }else{
                        set.remove(s.charAt(j));
                        j++;
                    }
                }
                set.add(s.charAt(j));
            }
        }
        return result;
    }
}