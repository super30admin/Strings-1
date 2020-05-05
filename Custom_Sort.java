// Time Complexity :O(mxn)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach

class Solution {
    public String customSortString(String S, String T) {
        HashMap<Character,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        for(Character c : T.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        for(Character c : S.toCharArray()){
            if(map.containsKey(c)){
                int count = map.get(c);
                while(count!=0){
                    sb.append(c);
                    count--;
                }
                map.remove(c);
            }
        }
        
        for(Map.Entry<Character,Integer> e: map.entrySet()){
            int val = e.getValue();
            char key = e.getKey();
            while(val!=0){
                sb.append(key);
                val--;
            }
        }
        
        return sb.toString();
    }
}