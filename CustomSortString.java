class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for(char c:order.toCharArray()){
            if(map.containsKey(c)){
                int freq= map.get(c);
                while(freq!=0){
                    sb.append(c);
                    freq--;
                }
                map.remove(c);
            }

            
        }

        for(char c:map.keySet()){
            int freq= map.get(c);
             while(freq!=0){
                sb.append(c);
                freq--;
            } 
        }

        return sb.toString();

    }
}