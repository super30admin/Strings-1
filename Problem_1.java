// Time complexity - O(T), length of String T
// Space complexity - O(1)

// Count frequency of pattern

class Solution {
    public String customSortString(String S, String T) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(char c : T.toCharArray()){
            if(map.containsKey(c)){
                int i = map.get(c);
                map.put(c,++i);
            }else{
                map.put(c,1);
            }
        }       
        for(char c : S.toCharArray()){
            if(map.containsKey(c)){
            int f = map.get(c);
            while(f > 0){
                sb.append(c);
                f--;
            }
            map.remove(c);   
            }  
        }
        
        for(Map.Entry<Character,Integer> e : map.entrySet()){
            char c = e.getKey();
            int f = e.getValue();
            while(f > 0){
                sb.append(c);
                f--;
            }
        }
        return sb.toString();
    }
}
