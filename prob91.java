// S30 Big N Problem #91 {Medium}
// 791. Custom Sort String
// Time Complexity : O(n) where n is the length of String S
// Space Complexity : O(m) {HashMap} where m is the length of String T
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None


// Your code here along with comments explaining your approach
class Solution {
    public String customSortString(String S, String T) {
        StringBuilder sb=new StringBuilder();
        HashMap<Character, Integer> map=new HashMap<>();
        
        for(char c:T.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        
        for(char c:S.toCharArray()){
            if(map.containsKey(c)){
                int count=map.get(c);
                while(count>0){
                    sb.append(c);
                    count--;
                }
                map.remove(c);
            }
        }
        
        for(Map.Entry <Character, Integer> entry:map.entrySet()){
            int count=entry.getValue();
            Character c=entry.getKey();
            while(count>0){
                sb.append(c);
                count--;
            }
            
        }
        return sb.toString();
    }
}