//Time Complexity: O(m) + O(n); where, m is the length of order and n is the length of s.
//Space Complexity: O(1)
//Code run successfully on LeetCode.

public class Problem1 {

    public String customSortString(String order, String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder result = new StringBuilder();
        
        for(int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
                
        for(int i =0; i < order.length(); i++){
            char c = order.charAt(i);
            
            if(map.containsKey(c)){
                
                int cnt = map.get(c);
               
                while(cnt > 0){
                    cnt--;
                    result.append(c);
                }
                
                map.remove(c);
            }
        }
        
        for(char c : map.keySet())
        {
            int cnt = map.get(c);
            
            while(cnt > 0){
                cnt--;
                result.append(c);
            }
        }
        
        return result.toString();
    }
}
