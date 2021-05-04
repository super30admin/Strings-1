//Time Complexity:O(m+n). m is the length of T and n is the length of S.
//Space Complexity : O(1), considering 26 different lowercase letters as constant. 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
// Your code here along with comments explaining your approach
class Solution {
    public String customSortString(String S, String T) {
        if(S==null || S.length()==0){
            return T;
        }
        StringBuilder sb = new StringBuilder();
        HashMap<Character,Integer> map = new HashMap<>();
        //map to maintain the frequency of characters in T
        for(int i=0;i<T.length();i++){
            map.put(T.charAt(i),map.getOrDefault(T.charAt(i),0)+1);
        }
        //iterate through S to get the order
        for(int j=0;j<S.length();j++){
            if(map.containsKey(S.charAt(j))){
                //get the count of occurences of the current character
                int count = map.get(S.charAt(j));
                //update the stringbuilder
                while(count>0){
                    sb.append(S.charAt(j));
                    count--;
                }
                map.remove(S.charAt(j));
            }
        }
        //append the remaining characters
        for(Character c : map.keySet()){
            int count = map.get(c);
                //update the stringbuilder
             while(count>0){
                sb.append(c);
                count--;
            }
        }
        return sb.toString();
    }
}