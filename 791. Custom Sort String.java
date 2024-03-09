class Solution {
    public String customSortString(String order, String s) {

        // counting sort
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        StringBuilder bldr = new StringBuilder();

        for(char c : order.toCharArray()){
            if(map.containsKey(c)){
                int len = map.get(c);
                map.remove(c);
                while(len-- > 0){
                    bldr.append(c);
                }
            }
        }

        if(!map.isEmpty()){
            Set<Map.Entry<Character, Integer>> set = map.entrySet();
            for(Map.Entry<Character, Integer> e : set){
                int len = e.getValue();
                while(len-- > 0){
                    bldr.append(e.getKey());
                }
            }
        }
        

        return bldr.toString();
    }
}
