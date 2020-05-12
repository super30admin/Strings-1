class Solution {
    public String customSortString(String S, String T) {
        
        // Runtime -: O(n+m)
        
        StringBuilder sb = new StringBuilder();
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        for (Character c : T.toCharArray()){
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        
        for (Character c : S.toCharArray()){
            if (map.containsKey(c)){
                int count = map.get(c);
                
                while (count > 0){
                    sb.append(c);
                    count--;
                }
                map.remove(c);
            }
        }
        
        for (Map.Entry<Character,Integer> entry :  map.entrySet()){
            Character key = entry.getKey();
            Integer value = entry.getValue();
            
            while(value > 0){
                sb.append(key);
                value--;
            }
        }
        
        return sb.toString();
        
    }
}