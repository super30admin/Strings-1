class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char c: s.toCharArray()){
            if(hm.containsKey(c)){
                hm.put(c,hm.get(c)+1);
            }
            else{
                hm.put(c,1);
            }
        }
        StringBuilder s2 = new StringBuilder();
        for(char c : order.toCharArray()){
            if(hm.containsKey(c)){
                while(hm.get(c)>0){
                    s2.append(c);
                    hm.put(c,hm.get(c)-1);
                }
            }
        }
        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
            char key = entry.getKey();
            Integer value = entry.getValue();
            while(hm.get(key)>0){
                s2.append(key);
                hm.put(key,hm.get(key)-1);

            }
            
        }
        String result = s2.toString();
        return result;
    }
}