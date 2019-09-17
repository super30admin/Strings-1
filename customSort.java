// Time Complexity : O(n)
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public String customSortString(String S, String T) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char t: T.toCharArray()){
            map.put(t,map.getOrDefault(t,0)+1);
        }
        
        StringBuilder sb = new StringBuilder();
        for(char s: S.toCharArray()){
            int freq = map.getOrDefault(s,0);
            for(int i=0; i<freq; i++){
                sb.append(s);
            }
            map.remove(s);
        }
        
        for(char t: map.keySet()){
            int freq = map.getOrDefault(t,0);
            for(int i=0; i<freq; i++){
                sb.append(t);
            }
        }
        return sb.toString();
    }
}