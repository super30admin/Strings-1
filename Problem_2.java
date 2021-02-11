// Time Complexity :O(n^2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==1){
            return 1;
        }
        // StringBuilder myStr=new StringBuilder();
        // myStr.append(s);
        int max=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                //System.out.println(myStr.substring(i,j+1));
                String st=s.substring(i,j+1);
                if(checkValidity(st)){
                    max=Math.max(max,st.length());
                }
            }
        }
        return max;
    }
    public boolean checkValidity(String str){
        HashSet<Character> hash=new HashSet<Character>();
        for(int i=0;i<str.length();i++){
            if(hash.contains(str.charAt(i))){
                return false;
            }else{
                hash.add(str.charAt(i));
            }
        }
        return true;
    }
}