// Time Complexity : O(s+o) where s is the length of string 's' and o is the length of string 'o'
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

class Solution {
    public String customSortString(String order, String s) {

        HashMap<Character,Integer> map = new HashMap<>(); // character and its frequencies

        StringBuilder result = new StringBuilder();

        for(int i=0;i<s.length();i++){
            Character current = s.charAt(i);
            if(!map.containsKey(current)){
                map.put(current, 0);
            }
            map.put(current , map.get(current) +1);
        }
        
        for(int i=0;i<order.length();i++){
            Character orderChar = order.charAt(i);
            if(map.containsKey(orderChar)){
                int count = map.get(orderChar);
                while(count>0){
                    result.append(orderChar);
                    count--;
                }
                map.remove(orderChar);
            }
        }

        if(map.size()>0){
            for(Character c : map.keySet()){
                int count = map.get(c);
                while(count>0){
                    result.append(c);
                    count--;
                }
            }
        }

        return result.toString();
        
    }
}


