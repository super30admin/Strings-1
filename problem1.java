// 791 Custom Sort String
// Solved on leetcode
// Time Complexity : O(n)
// Space Complexity : O(n)


class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(!map.containsKey(ch)){
                map.put(ch,1);
            }else{
                map.put(ch,map.get(ch)+1);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<order.length();i++){
            char ch = order.charAt(i);
            
            if(map.containsKey(ch)){
                int k = map.get(ch);
                for(int j=0;j<k;j++){
                    sb.append(ch);
                }
            }
            map.remove(ch);
        }
        
        for(Map.Entry <Character,Integer>  current: map.entrySet()){
            int k = current.getValue();
            char ch = current.getKey();
            
            for(int i=0;i<k;i++){
                sb.append(ch);
            }
        }
        
        return sb.toString();
        
        
    }
}