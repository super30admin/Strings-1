package s30.Strings-1;

public class problem1 {
    class Solution {
        //TC:- O(1)
        //SC:- O(1)
        public String customSortString(String order, String s) {
            if(order == null || order.length() == 0 || s == null || s.length() == 0) return s;
            
            HashMap<Character, Integer> map = new HashMap<>();
            
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                map.put(c, map.getOrDefault(c,0) + 1);
            }
            
            StringBuilder sb = new StringBuilder();
            
             for(int i = 0; i < order.length(); i++){
                char c = order.charAt(i);
                if(map.containsKey(c)){
                    int count = map.get(c);
                    map.remove(c);
                    while(count > 0){
                        sb.append(c);
                        count--;
                    }
                }
            }
            
            for(char key : map.keySet()){
                int count = map.get(key);
                while(count > 0){
                    sb.append(key);
                    count--;
                }
            }
            
            return sb.toString();
        }
    }
}
