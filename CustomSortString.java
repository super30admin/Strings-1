//Time Complexity : O(n)
//Space Complexity : O(n)
class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c,0);
            }
        
            map.put(c, map.get(c) + 1);
        }
        for(int i=0; i < order.length(); i++){
            char ch = order.charAt(i);
            if(map.containsKey(ch)){
                int count = map.get(ch);
                for(int k=0; k <count; k++){
                    sb.append(ch);
                }
                map.remove(ch);
            }
        }

        for(char ch : map.keySet()){
            int count = map.get(ch);
            for(int k =0; k < count; k++){
                sb.append(ch);
            }
        }
    return sb.toString();
    }
}
