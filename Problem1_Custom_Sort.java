class Solution {
    public String customSortString(String order, String s) {
        if(s==null || s.length() == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        //1. Store the given string/frequency in map
        for(int i = 0; i<s.length() ; i++){
            char c = s.charAt(i);
            // if(!map.containsKey(c)){
                map.put(c, map.getOrDefault(c,0)+1);
            // }
            // map.put(c,1);
        }
        //Follow the sequence and start building the string
        for(int i=0; i<order.length(); i++){
            char c = order.charAt(i);
            if(map.containsKey(c)){
                int times = map.get(c);
                for(int j = 0; j < times; j++){
                    sb.append(c);
                }
                map.remove(c);
            }
        }
        //Check for any remaining chars left in map
        for(char c : map.keySet()){
            int times = map.get(c);
            for(int i=0; i<times; i++){
                sb.append(c);
            }
            // map.remove(c);
        }
        return sb.toString();
    }
}
