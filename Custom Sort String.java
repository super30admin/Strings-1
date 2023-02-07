// Time Complexity = O(n)
// Space Complexity = O(1)

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i <s.length(); i ++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < order.length(); i ++){
            char ch = order.charAt(i);
            if(map.containsKey(ch)){
                for(int j = 0; j < map.get(ch); j++){
                    sb.append(ch);
                }
            }
             map.remove(ch);
        }
        
        for (char key : map.keySet()){
            for(int j = 0; j < map.get(key); j++){
                    sb.append(key);
            }
        }
        
        return sb.toString();
    }
}


