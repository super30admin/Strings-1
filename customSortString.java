//Time : O(n)
//Space : O(1)
//Leetcode : Yes

class Solution {
    public String customSortString(String S, String T) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : T.toCharArray()){
            map.put(c, map.getOrDefault(c,0) +1);
        }
        
        for(char c : S.toCharArray()){
            if(map.containsKey(c)){
                for(int i =0;i<map.get(c);i++){
                    sb.append(c);
                }
                map.remove(c);
            }
        }
        
        for(Map.Entry<Character,Integer> entry : map.entrySet() ){
            char c = entry.getKey();
            for(int i =0;i<map.get(c);i++){
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}