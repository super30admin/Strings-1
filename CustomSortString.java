class Solution {
    public String customSortString(String S, String T) {
        Map<Character, Integer> strMap = new HashMap();
        
        for(char c : T.toCharArray()){
            strMap.put(c, strMap.getOrDefault(c, 0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for(char c : S.toCharArray()){
            if(strMap.containsKey(c)){
                for(int i = 0; i < strMap.get(c); i++){
                    sb.append(c);
                }
                strMap.remove(c);
            }
        }
        for(Map.Entry<Character,Integer> entry : strMap.entrySet()){
            for(int i = 0; i < entry.getValue(); i++){
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}
