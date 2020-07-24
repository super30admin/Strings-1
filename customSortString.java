// Time Complexity : O(sum of lengths of both strings)
// Space Complexity :O(T.length)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public String customSortString(String S, String T) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<T.length();i++){
            Character c = T.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        StringBuilder str = new StringBuilder();
        for(int i = 0;i<S.length();i++){
            Character c = S.charAt(i);
            if(map.containsKey(c)){
                int count = map.get(c);
                while(count>0){
                    count--;
                    str.append(c);
                }
                map.remove(c);
            }
            
        }
        
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            Character c = entry.getKey();
            Integer count = entry.getValue();
            while(count>0){
                    count--;
                    str.append(c);
                }
            
        }
        return str.toString();
    }
}